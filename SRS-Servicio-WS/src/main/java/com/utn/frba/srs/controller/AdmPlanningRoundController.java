package com.utn.frba.srs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.utn.frba.srs.controller.dto.PlanificacionRondaDTO;
import com.utn.frba.srs.controller.dto.RequestGeneric;
import com.utn.frba.srs.exception.SRSException;

public interface AdmPlanningRoundController {
	
	@PostMapping(path = "/planificacionRonda")
	public void crear(@RequestBody RequestGeneric<PlanificacionRondaDTO> request) throws SRSException;
	
	@GetMapping(path = "/planificacionRonda/{idRonda}")
	public void obtenerPorIdRonda(@PathVariable("idRonda") Long idRonda) throws SRSException;
	
	
   
}
