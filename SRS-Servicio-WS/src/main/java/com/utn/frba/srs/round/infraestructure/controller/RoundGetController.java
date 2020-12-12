package com.utn.frba.srs.round.infraestructure.controller;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.round.application.RoundFind;
import com.utn.frba.srs.round.application.RoundFind.RoundQuery;
import com.utn.frba.srs.round.infraestructure.controller.RoundGetController.Response;
import com.utn.frba.srs.shared.infraestructure.controller.GenericWS;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@RestController
@RequestMapping(path = "/v1")
@Api(tags = "AdmRound", description = ("AdmRound"))
public class RoundGetController extends GenericWS {

	@Autowired
	private RoundFind roundFind;

	private RoundFindQueryMapper mapper = Mappers.getMapper(RoundFindQueryMapper.class);

	@GetMapping(path = "/round/{id}")
	public ResponseEntity<Response> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(mapper.roundQueryToResponse(roundFind.findById(id)));
	}

	@GetMapping(path = "/round/{subsidiaryId}/{roundName}")
	public ResponseEntity<Response> findBySubsidiaryAndRoundName(@PathVariable("subsidiaryId") Long subsidiaryId,
			@PathVariable("roundName") String roundName) {
		return ResponseEntity
				.ok(mapper.roundQueryToResponse(roundFind.findBySubsidiaryAndName(subsidiaryId, roundName)));
	}

	@GetMapping(path = "/rounds/{subsidiaryId}")
	public ResponseEntity<List<Response>> findBySubsidiary(@PathVariable("subsidiaryId") Long subsidiaryId) {
		return ResponseEntity.ok(roundFind.findBySubsidiary(subsidiaryId).stream()
				.map(a -> mapper.roundQueryToResponse(a)).collect(Collectors.toList()));
	}

	@Data
	public static class Response implements Serializable {
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
		private List<Response.RoundCheckpointDTO> checkpoints;

		@NotNull
		private List<Response.RoundRouteDTO> routes;

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
			private Response.RoundCheckpointDTO.CheckpointDTO checkpoint;

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
interface RoundFindQueryMapper {
	public Response roundQueryToResponse(RoundQuery response);
}
