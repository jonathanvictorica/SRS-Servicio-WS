package com.utn.frba.srs.controller.impl;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.controller.AdmIncidentController;
import com.utn.frba.srs.controller.dto.CerrarIncidenteDTO;
import com.utn.frba.srs.controller.dto.IncidenteDTO;
import com.utn.frba.srs.controller.dto.RequestGeneric;
import com.utn.frba.srs.controller.dto.ResponseGeneric;
import com.utn.frba.srs.controller.dto.SeveridadDTO;
import com.utn.frba.srs.exception.SRSException;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "/v1")
@Api(tags = "AdministrarIncidente", description = ("AdministrarIncidente"))
public class AdmIncidenteControllerImpl extends GenericWS
		implements AdmIncidentController {

	@Override
	public void crear(RequestGeneric<IncidenteDTO> request) throws SRSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cerrarIncidente(RequestGeneric<CerrarIncidenteDTO> request) throws SRSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseGeneric<IncidenteDTO> obtenerPorId(Long id) throws SRSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseGeneric<List<SeveridadDTO>> listarSeveridades() throws SRSException {
		// TODO Auto-generated method stub
		return null;
	}



	

}
