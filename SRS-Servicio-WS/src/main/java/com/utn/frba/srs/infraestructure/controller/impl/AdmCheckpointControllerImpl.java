package com.utn.frba.srs.infraestructure.controller.impl;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.domain.exception.SRSException;
import com.utn.frba.srs.infraestructure.controller.AdmCheckpointController;
import com.utn.frba.srs.infraestructure.controller.dto.CheckpointDTO;
import com.utn.frba.srs.infraestructure.controller.dto.RequestGeneric;
import com.utn.frba.srs.infraestructure.controller.dto.ResponseGeneric;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "/v1")
@Api(tags = "AdministrarCheckpoint", description = ("AdministrarCheckpoint"))
public class AdmCheckpointControllerImpl extends GenericWS
		implements AdmCheckpointController {

	@Override
	public void crear(RequestGeneric<CheckpointDTO> request) throws SRSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) throws SRSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseGeneric<List<CheckpointDTO>> listarPorSucursal(Long idSucursal) throws SRSException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
