package com.utn.frba.srs.checkpoint.infraestructure.controller;

import java.io.Serializable;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.checkpoint.application.FindCheckpoint;
import com.utn.frba.srs.checkpoint.infraestructure.controller.CheckpointGetContoller.CheckpointGetResponse;
import com.utn.frba.srs.shared.domain.DomainException;
import com.utn.frba.srs.shared.infraestructure.controller.GenericWS;

import io.swagger.annotations.Api;
import lombok.Data;

@RestController
@RequestMapping(path = "/v1")
@Api(tags = "AdmCheckpoint", description = ("AdmCheckpoint"))
public class CheckpointGetContoller extends GenericWS {
	private CheckpointFindQueryMapper mapper = Mappers.getMapper(CheckpointFindQueryMapper.class);

	@GetMapping(path = "/checkpoint/{id}")
	public ResponseEntity<CheckpointGetResponse> findById(@PathVariable("id") UUID id) throws DomainException {
		return ResponseEntity
				.ok(mapper.fromCheckpointQuery(queryBusSync.ask(new FindCheckpoint.CheckpointCriteriaQuery(id))));
	}

	@Data
	public static class CheckpointGetResponse implements Serializable {

		private static final long serialVersionUID = 1L;

		private UUID id;

		private String nfcIdentification;

		private CheckpointGetResponse.Ubication ubication;

		private UUID subsidiaryId;

		@Data
		public static class Ubication implements Serializable {

			private static final long serialVersionUID = 1L;
			private String latitude;
			private String longitude;

		}

	}

}

@Mapper
interface CheckpointFindQueryMapper {
	public CheckpointGetResponse fromCheckpointQuery(FindCheckpoint.CheckpointsQuery response);
}
