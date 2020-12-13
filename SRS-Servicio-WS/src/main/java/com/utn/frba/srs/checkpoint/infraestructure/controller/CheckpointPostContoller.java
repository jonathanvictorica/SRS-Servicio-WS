package com.utn.frba.srs.checkpoint.infraestructure.controller;

import java.io.Serializable;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.checkpoint.application.CheckpointCreateHandler.CheckpointCreateCommand;
import com.utn.frba.srs.shared.infraestructure.controller.GenericWS;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "/v1")
@Api(tags = "AdmCheckpoint", description = ("AdmCheckpoint"))
public class CheckpointPostContoller extends GenericWS {

	private CheckpointCreateCommandMapper mapper = Mappers.getMapper(CheckpointCreateCommandMapper.class);

	@PostMapping(path = "/checkpoint")
	public void create(@RequestBody CheckpointPostRequest request) throws Exception {
		commandBusSync.invoke(mapper.createCheckpointCreateCommand(request));
	}

	@lombok.Data
	public static class CheckpointPostRequest implements Serializable {
		private static final long serialVersionUID = 1L;

		private Long id;

		private String nfcIdentification;

		private CheckpointPostRequest.Ubication ubication;

		private Long subsidiaryId;

		@lombok.Data
		public static class Ubication implements Serializable {
			private static final long serialVersionUID = 1L;

			private String latitude;

			private String longitude;
		}

	}

}

@Mapper
interface CheckpointCreateCommandMapper {
	public CheckpointCreateCommand createCheckpointCreateCommand(
			com.utn.frba.srs.checkpoint.infraestructure.controller.CheckpointPostContoller.CheckpointPostRequest request);
}
