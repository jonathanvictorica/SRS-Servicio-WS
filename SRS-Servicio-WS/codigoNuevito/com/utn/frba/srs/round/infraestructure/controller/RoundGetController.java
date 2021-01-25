package com.utn.frba.srs.round.infraestructure.controller;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.round.application.FindRound.RoundListQuery;
import com.utn.frba.srs.round.application.FindRound.RoundQuery;
import com.utn.frba.srs.round.application.FindRoundByIdHandler;
import com.utn.frba.srs.round.application.FindRoundBySubsidiaryHandler;
import com.utn.frba.srs.round.application.FindRoundBySubsidiryAndNameHandler;
import com.utn.frba.srs.round.infraestructure.controller.RoundGetController.RoundGetResponse;
import com.utn.frba.srs.shared.infraestructure.controller.GenericWS;

import io.swagger.annotations.Api;
import lombok.Data;

@RestController
@RequestMapping(path = "/v1")
@Api(tags = "AdmRound", description = ("AdmRound"))
public class RoundGetController extends GenericWS {

	private RoundFindQueryMapper mapper = Mappers.getMapper(RoundFindQueryMapper.class);

	@GetMapping(path = "/round/{id}")
	public ResponseEntity<RoundGetResponse> findById(@PathVariable("id") Long id) throws Exception {
		RoundQuery result = queryBusSync.ask(new FindRoundByIdHandler.FindRoundByIdQuery(id));
		return ResponseEntity.ok(mapper.roundQueryToResponse(result));
	}

	@GetMapping(path = "/round/{subsidiaryId}/{roundName}")
	public ResponseEntity<RoundGetResponse> findBySubsidiaryAndRoundName(
			@PathVariable("subsidiaryId") Long subsidiaryId, @PathVariable("roundName") String roundName)
			throws Exception {
		RoundQuery result = queryBusSync
				.ask(new FindRoundBySubsidiryAndNameHandler.FindRoundBySubsidiryAndNameQuery(subsidiaryId, roundName));
		return ResponseEntity.ok(mapper.roundQueryToResponse(result));
	}

	@GetMapping(path = "/rounds/{subsidiaryId}")
	public ResponseEntity<List<RoundGetResponse>> findBySubsidiary(@PathVariable("subsidiaryId") Long subsidiaryId)
			throws Exception {
		RoundListQuery result = queryBusSync
				.ask(new FindRoundBySubsidiaryHandler.FindRoundBySubsidiaryQuery(subsidiaryId));
		return ResponseEntity
				.ok(result.getRounds().stream().map(a -> mapper.roundQueryToResponse(a)).collect(Collectors.toList()));
	}

	@Data
	public static class RoundGetResponse implements Serializable {
		private static final long serialVersionUID = 1L;

		private Long id;

		private Long subsidiaryId;

		private String name;

		private String description;

		private List<RoundGetResponse.RoundCheckpoint> checkpoints;

		private List<RoundGetResponse.RoundRoute> routes;

		private Ubication ubication;

		private String zoomUbication = "0";

		private Integer roundTime;

		@Data
		public static class RoundCheckpoint implements Serializable {

			private static final long serialVersionUID = 1L;

			private Long id;

			private RoundGetResponse.RoundCheckpoint.Checkpoint checkpoint;

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

			private RoundGetResponse.Ubication ubication;

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
	public RoundGetResponse roundQueryToResponse(RoundQuery response);
}
