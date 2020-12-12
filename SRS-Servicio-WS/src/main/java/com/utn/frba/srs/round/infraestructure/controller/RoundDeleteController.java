package com.utn.frba.srs.round.infraestructure.controller;

import java.io.Serializable;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.infraestructure.controller.impl.GenericWS;
import com.utn.frba.srs.round.application.RoundDelete;
import com.utn.frba.srs.round.application.RoundDelete.RoundDeleteCommand;
import com.utn.frba.srs.round.infraestructure.controller.RoundDeleteController.Request;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "/v1")
@Api(tags = "AdmRound", description = ("AdmRound"))
public class RoundDeleteController extends GenericWS {

	@Autowired
	private RoundDelete roundDelete;

	private RoundDeleteCommandMapper mapper = Mappers.getMapper(RoundDeleteCommandMapper.class);

	@DeleteMapping(path = "/round")
	public void delete(@RequestBody Request request) {
		roundDelete.invoke(mapper.requestToRoundDeleteCommand(request));
	}

	public static @lombok.Data class Request implements Serializable {
		private static final long serialVersionUID = 1L;

		private Long id;
		
		private String identificadorUsuario;

	}

}

@Mapper
interface RoundDeleteCommandMapper {
	public RoundDeleteCommand requestToRoundDeleteCommand(Request request);
}
