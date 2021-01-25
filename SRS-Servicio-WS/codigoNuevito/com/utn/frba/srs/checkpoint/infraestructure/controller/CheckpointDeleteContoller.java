package com.utn.frba.srs.checkpoint.infraestructure.controller;

import java.io.Serializable;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.checkpoint.application.DeleteCheckpoint.DeleteCheckpointCommand;
import com.utn.frba.srs.shared.infraestructure.controller.GenericWS;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "/v1")
@Api(tags = "AdmCheckpoint", description = ("AdmCheckpoint"))
public class CheckpointDeleteContoller extends GenericWS {
	private CheckpointDeleteCommandMapper mapper = Mappers.getMapper(CheckpointDeleteCommandMapper.class);

	@DeleteMapping(path = "/checkpoint")
	public void delete(@RequestBody CheckpointDeleteContoller.CheckpointDeleteRequest request) throws Exception {
		commandBusAsync.invoke(mapper.requestToCheckpointDeleteCommand(request));
	}

	public static @lombok.Data class CheckpointDeleteRequest implements Serializable {
		private static final long serialVersionUID = 1L;

		private UUID id;

		private String identificadorUsuario;

	}
}
@Mapper
interface CheckpointDeleteCommandMapper {
	public DeleteCheckpointCommand requestToCheckpointDeleteCommand(CheckpointDeleteContoller.CheckpointDeleteRequest request);
}
