package com.utn.frba.srs.round.infraestructure.controller;

import java.io.Serializable;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.round.application.DeleteRoundHandler.DeleteRoundCommand;
import com.utn.frba.srs.round.infraestructure.controller.RoundDeleteController.RoundDeleteRequest;
import com.utn.frba.srs.shared.infraestructure.controller.GenericWS;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "/v1")
@Api(tags = "AdmRound", description = ("AdmRound"))
public class RoundDeleteController extends GenericWS {

	
	private RoundDeleteCommandMapper mapper = Mappers.getMapper(RoundDeleteCommandMapper.class);
	


	@DeleteMapping(path = "/round")
	public void delete(@RequestBody RoundDeleteController.RoundDeleteRequest request) throws Exception {
		commandBusAsync.invoke(mapper.requestToRoundDeleteCommand(request));
	}

	public static @lombok.Data class RoundDeleteRequest implements Serializable {
		private static final long serialVersionUID = 1L;

		private Long id;
		
		private String identificadorUsuario;

	}

}

@Mapper
interface RoundDeleteCommandMapper {
	public DeleteRoundCommand requestToRoundDeleteCommand(RoundDeleteRequest request);
}
