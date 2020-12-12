package com.utn.frba.srs.infraestructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.utn.frba.srs.domain.exception.SRSException;

public interface ActionRoundExecutionController {

	@PutMapping(path = "/rondaEjecucion/iniciar/idRonda/{idRonda}/idVigilante/{idVigilante}")
	public void iniciarRonda(@PathVariable("idRonda") Long idRonda,@PathVariable("idVigilante") Long idVigilante) throws SRSException;

	@PutMapping(path = "/rondaEjecucion/idCheckpoint/{idCheckpoint}/idVigilante/{idVigilante}")
	public void marcarCheckPoint(@PathVariable("idCheckpoint") Long idCheckpoint,@PathVariable("idVigilante") Long idVigilante) throws SRSException;

	@PutMapping(path = "/rondaEjecucion/finalizar/idRonda/{idRonda}/idVigilante/{idVigilante}")
	public void finalizarRonda(@PathVariable("idRonda") Long idRonda,@PathVariable("idVigilante") Long idVigilante) throws SRSException;

	@PutMapping(path = "/rondaEjecucion/idVigilante/{idVigilante}/latitud/{latitud}/longitud/{longitud}")
	public void notificarUbicacionVigilante(@PathVariable("idVigilante") Long idUsuario,@PathVariable("latitud") String latitud,@PathVariable("longitud") String longitud) throws SRSException;

	@PutMapping(path = "/rondaEjecucion/idRonda/{idRonda}/idSupervisor/{idSupervisor}")
	public void finalizarPorSupervisor(@PathVariable("idRonda") Long idRonda,@PathVariable("idSupervisor") Long idSupervisor) throws SRSException;

	@GetMapping(path = "/rondaEjecuciones/{idEmpresa}")
	public Object listarRondaRevisarPorEmpresaSeguridad(@PathVariable("idEmpresa") Long idEmpresa) throws SRSException;

	@GetMapping(path = "/rondaEjecucion/{id}")
	public Object obtenerPorId(@PathVariable("id") Long id) throws SRSException;

}
