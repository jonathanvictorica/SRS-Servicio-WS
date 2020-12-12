package com.utn.frba.srs.infraestructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.utn.frba.srs.domain.exception.SRSException;

public interface ActionPlanningRoundController {

	@GetMapping(path = "/planificacionRonda/idcliente/{idcliente}/latitud/{latitud}/longitud/{longitud}")
	public void consultarPlanificacionPorSucursal(@PathVariable("idcliente") Long idcliente,
			@PathVariable("latitud") Long latitud, @PathVariable("longitud") Long longitud) throws SRSException;

	@PutMapping(path = "/planificacionRonda/ejecutarPlanificacion")
	public void ejecucionManual() throws SRSException;
}
