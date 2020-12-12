package com.utn.frba.srs.round.infraestructure.controller;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

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

		private Long subsidiaryId;

		private String name;

		private String description;

		private List<Response.RoundCheckpoint> checkpoints;

		private List<Response.RoundRoute> routes;

		private Ubication ubication;

		private String zoomUbication = "0";

		private Integer roundTime;

		@Data
		public static class RoundCheckpoint implements Serializable {

			private static final long serialVersionUID = 1L;

			private Long id;

			private Response.RoundCheckpoint.Checkpoint checkpoint;

			private Integer executionOrder;

			@Data
			public static class Checkpoint implements Serializable {

				private static final long serialVersionUID = 1L;

				private Long id;

				private String nfcIdentification;

				private Ubication ubication;
			}
		}

		@Data
		public static class RoundRoute implements Serializable {

			private static final long serialVersionUID = 1L;

			private Long id;

			private int routeOrder;

			private Response.Ubication ubication;

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
interface RoundFindQueryMapper {
	public Response roundQueryToResponse(RoundQuery response);
}
