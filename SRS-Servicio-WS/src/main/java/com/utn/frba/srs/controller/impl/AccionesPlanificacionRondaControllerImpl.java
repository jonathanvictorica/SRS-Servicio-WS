package com.utn.frba.srs.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.controller.ActionPlanningRoundController;
import com.utn.frba.srs.exception.SRSException;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "/v1")
@Api(tags = "AccionesPlanificacionRonda", description = ("AccionesPlanificacionRonda"))
public class AccionesPlanificacionRondaControllerImpl extends GenericWS
		implements ActionPlanningRoundController {

	@Override
	public void consultarPlanificacionPorSucursal(Long idcliente, Long latitud, Long longitud) throws SRSException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ejecucionManual() throws SRSException {
		// TODO Auto-generated method stub

	}

}
