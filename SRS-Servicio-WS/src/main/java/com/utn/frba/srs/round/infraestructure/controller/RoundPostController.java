package com.utn.frba.srs.round.infraestructure.controller;

import java.io.Serializable;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.round.application.RoundCreate;
import com.utn.frba.srs.round.application.RoundCreate.RoundCreateCommand;
import com.utn.frba.srs.round.infraestructure.controller.RoundPostController.Request;
import com.utn.frba.srs.shared.infraestructure.controller.GenericWS;

import io.swagger.annotations.Api;
import lombok.Data;

@RestController
@RequestMapping(path = "/v1")
@Api(tags = "AdmRound", description = ("AdmRound"))
public class RoundPostController extends GenericWS {

	@Autowired
	private RoundCreate roundCreate;

	private RoundCreateCommandMapper mapper = Mappers.getMapper(RoundCreateCommandMapper.class);

	@PostMapping(path = "/round")
	public void create(@RequestBody Request request) {
		roundCreate.invoke(mapper.requestToRoundCreateCommand(request));
	}

	public static @lombok.Data class Request implements Serializable {
		private static final long serialVersionUID = 1L;

		private Long id;

		private Long subsidiaryId;

		private String name;

		private String description;

		private List<Request.RoundCheckpoint> checkpoints;

		private List<Request.RoundRoute> routes;

		private Ubication ubication;

		private String zoomUbication = "0";

		private Integer roundTime;

		@Data
		public static class RoundCheckpoint implements Serializable {

			private static final long serialVersionUID = 1L;

			private Request.RoundCheckpoint.Checkpoint checkpoint;

			private Integer executionOrder;

			@Data
			public static class Checkpoint implements Serializable {

				private static final long serialVersionUID = 1L;

				private Long id;

			}
		}

		@Data
		public static class RoundRoute implements Serializable {

			private static final long serialVersionUID = 1L;

			private int routeOrder;

			private Request.Ubication ubication;

		}

		@Data
		public static class Ubication implements Serializable {

			private static final long serialVersionUID = 1L;

			private String latitude;

			private String longitude;
		}

	}

}

@Mapper
interface RoundCreateCommandMapper {
	public RoundCreateCommand requestToRoundCreateCommand(Request request);
}
