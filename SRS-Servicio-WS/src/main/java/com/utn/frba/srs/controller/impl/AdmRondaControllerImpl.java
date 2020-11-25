package com.utn.frba.srs.controller.impl;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.controller.AdmRoundController;
import com.utn.frba.srs.controller.dto.RequestGeneric;
import com.utn.frba.srs.controller.dto.ResponseGeneric;
import com.utn.frba.srs.controller.dto.RondaDTO;
import com.utn.frba.srs.exception.SRSException;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "/v1")
@Api(tags = "AdministrarRonda", description = ("AdministrarRonda"))
public class AdmRondaControllerImpl extends GenericWS implements AdmRoundController {

	@Override
	public void crear(RequestGeneric<RondaDTO> request) throws SRSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) throws SRSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseGeneric<RondaDTO> obtenerPorId(Long id) throws SRSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseGeneric<List<RondaDTO>> listarPorSucursal(Long idSucursal) throws SRSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseGeneric<RondaDTO> obtenerPorSucursalPorNombreRonda(Long idSucursal, String nombreRonda)
			throws SRSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseGeneric<List<RondaDTO>> listarPorEmpresa(Long idEmpresaSeguridad) throws SRSException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
