package com.utn.frba.srs.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.controller.AdmPlanningRoundController;
import com.utn.frba.srs.controller.dto.PlanificacionRondaDTO;
import com.utn.frba.srs.controller.dto.RequestGeneric;
import com.utn.frba.srs.exception.SRSException;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "/v1")
@Api(tags = "AdministrarPlanificacionRonda", description = ("AdministrarPlanificacionRonda"))
public class AdmPlanificacionRondaControllerImpl extends GenericWS
		implements AdmPlanningRoundController {

	@Override
	public void crear(RequestGeneric<PlanificacionRondaDTO> request) throws SRSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void obtenerPorIdRonda(Long idRonda) throws SRSException {
		// TODO Auto-generated method stub
		
	}



	

}
