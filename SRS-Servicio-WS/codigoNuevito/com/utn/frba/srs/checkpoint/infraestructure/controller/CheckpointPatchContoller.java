package com.utn.frba.srs.checkpoint.infraestructure.controller;

import java.io.Serializable;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.checkpoint.application.UpdateCheckpointUbication.UpdateCheckpointUbicationCommand;
import com.utn.frba.srs.shared.domain.DomainException;
import com.utn.frba.srs.shared.infraestructure.controller.GenericWS;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "/v1")
@Api(tags = "AdmCheckpoint", description = ("AdmCheckpoint"))
public class CheckpointPatchContoller extends GenericWS {

	private CheckpointUpdateCommandMapper mapper = Mappers.getMapper(CheckpointUpdateCommandMapper.class);

	@PatchMapping(path = "/checkpoint")
	public void updateUbication(@RequestBody CheckpointPatchRequest request) throws DomainException {
		commandBusSync.invoke(mapper.fromCheckpointPatchRequest(request));
	}

	@lombok.Data
	public static class CheckpointPatchRequest implements Serializable {
		private static final long serialVersionUID = 1L;

		private UUID id;

		private CheckpointPatchRequest.Ubication ubication;

		@lombok.Data
		public static class Ubication implements Serializable {
			private static final long serialVersionUID = 1L;

			private String latitude;

			private String longitude;
		}

	}

}

@Mapper
interface CheckpointUpdateCommandMapper {
	public UpdateCheckpointUbicationCommand fromCheckpointPatchRequest(
			CheckpointPatchContoller.CheckpointPatchRequest request);
}
