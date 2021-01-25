package com.utn.frba.srs.round.infraestructure.controller;

import java.io.Serializable;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.round.application.CreateRoundHandler.CreateRoundCommand;
import com.utn.frba.srs.round.infraestructure.controller.RoundPostController.RoundPostRequest;
import com.utn.frba.srs.shared.domain.DomainException;
import com.utn.frba.srs.shared.infraestructure.controller.GenericWS;

import io.swagger.annotations.Api;
import lombok.Data;

@RestController
@RequestMapping(path = "/v1")
@Api(tags = "AdmRound", description = ("AdmRound"))
public class RoundPostController extends GenericWS {

	private RoundCreateCommandMapper mapper = Mappers.getMapper(RoundCreateCommandMapper.class);

	@PostMapping(path = "/round")
	public void create(@RequestBody RoundPostRequest request) throws DomainException  {
		commandBusSync.invoke(mapper.createRoundCreateCommand(request));
	}

	public static @lombok.Data class RoundPostRequest implements Serializable {
		private static final long serialVersionUID = 1L;

		private Long id;

		private Long subsidiaryId;

		private String name;

		private String description;

		private List<RoundPostRequest.RoundCheckpoint> checkpoints;

		private List<RoundPostRequest.RoundRoute> routes;

		private Ubication ubication;

		private String zoomUbication = "0";

		private Integer roundTime;

		@Data
		public static class RoundCheckpoint implements Serializable {

			private static final long serialVersionUID = 1L;

			private RoundPostRequest.RoundCheckpoint.Checkpoint checkpoint;

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

			private RoundPostRequest.Ubication ubication;

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
	public CreateRoundCommand createRoundCreateCommand(RoundPostRequest request);
}
