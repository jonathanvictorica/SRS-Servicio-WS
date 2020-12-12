package com.utn.frba.srs.infraestructure.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.domain.exception.SRSException;
import com.utn.frba.srs.infraestructure.controller.ActionRoundExecutionController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "/v1")
@Api(tags = "AccionesRondaEjecucion", description = ("AccionesRondaEjecucion"))
public class AccionesRondaEjecucionControllerImpl extends GenericWS
		implements ActionRoundExecutionController {

	@Override
	public void iniciarRonda(Long idRonda, Long idVigilante) throws SRSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void marcarCheckPoint(Long idCheckpoint, Long idVigilante) throws SRSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizarRonda(Long idRonda, Long idVigilante) throws SRSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notificarUbicacionVigilante(Long idUsuario, String latitud, String longitud) throws SRSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizarPorSupervisor(Long idRonda, Long idSupervisor) throws SRSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object listarRondaRevisarPorEmpresaSeguridad(Long idEmpresa) throws SRSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object obtenerPorId(Long id) throws SRSException {
		// TODO Auto-generated method stub
		return null;
	}
}
