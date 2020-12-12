package com.utn.frba.srs.round.infraestructure.controller;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.infraestructure.controller.dto.RoundDTO;
import com.utn.frba.srs.infraestructure.controller.impl.GenericWS;
import com.utn.frba.srs.round.application.RoundCreate;
import com.utn.frba.srs.round.application.RoundCreate.RoundCreateCommand;
import com.utn.frba.srs.round.infraestructure.controller.RoundPostController.Request;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
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

		@NotNull
		private Long subsidiaryId;

		@NotNull
		@ApiModelProperty(example = "Nombre")
		private String name;

		@NotNull
		@ApiModelProperty(example = "Descripcion")
		private String description;

		@NotNull
		private List<RoundDTO.RoundCheckpointDTO> checkpoints;

		@NotNull
		private List<RoundDTO.RoundRouteDTO> routes;

		@NotNull
		private UbicationDTO ubication;

		@NotNull
		@ApiModelProperty(example = "0")
		private String zoomUbication = "0";

		@NotNull
		@ApiModelProperty(example = "1")
		private Integer roundTime;

		@NotNull
		@ApiModelProperty(example = "1")
		private Long userId;

		@Data
		public static class RoundSubsidiaryDTO implements Serializable {

			private static final long serialVersionUID = 1L;

			@NotNull
			@ApiModelProperty(example = "1")
			private Long id;

		}

		@Data
		public static class RoundStateDTO implements Serializable {

			private static final long serialVersionUID = 1L;

			@ApiModelProperty
			private String name;

		}

		@Data
		public static class RoundCheckpointDTO implements Serializable {

			private static final long serialVersionUID = 1L;

			@NotNull
			private RoundDTO.RoundCheckpointDTO.CheckpointDTO checkpoint;

			@ApiModelProperty(example = "1")
			@NotNull
			private Integer executionOrder;

			@Data
			public static class CheckpointDTO implements Serializable {
				private static final long serialVersionUID = 1L;

				@ApiModelProperty(example = "1")
				@NotNull
				private Long id;

			}

		}

		@Data
		public static class RoundRouteDTO implements Serializable {

			private static final long serialVersionUID = 1L;

			@ApiModelProperty(example = "1")
			@NotNull
			private int routeOrder;

			private UbicationDTO ubication;

		}

		@Data
		public static class UbicationDTO implements Serializable {

			private static final long serialVersionUID = 1L;
			@NotNull
			@ApiModelProperty(example = "11111111")
			private String latitude;

			@NotNull
			@ApiModelProperty(example = "222222222")
			private String longitude;
		}

	}

}

@Mapper
interface RoundCreateCommandMapper {
	public RoundCreateCommand requestToRoundCreateCommand(Request request);
}
