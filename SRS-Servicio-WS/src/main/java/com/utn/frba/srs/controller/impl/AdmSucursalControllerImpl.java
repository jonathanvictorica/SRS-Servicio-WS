package com.utn.frba.srs.controller.impl;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.controller.AdmSubsidiaryController;
import com.utn.frba.srs.controller.dto.RequestGeneric;
import com.utn.frba.srs.controller.dto.ResponseGeneric;
import com.utn.frba.srs.controller.dto.SucursalDTO;
import com.utn.frba.srs.exception.SRSException;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "/v1")
@Api(tags = "AdministrarSucursal", description = ("AdministrarSucursal"))
public class AdmSucursalControllerImpl extends GenericWS implements AdmSubsidiaryController {

	@Override
	public void crear(RequestGeneric<SucursalDTO> request) throws SRSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(RequestGeneric<SucursalDTO> request) throws SRSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) throws SRSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseGeneric<SucursalDTO> obtenerPorId(Long id) throws SRSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseGeneric<SucursalDTO> obtenerPorIdClientePorNombre(Long idCliente, String nombre)
			throws SRSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseGeneric<List<SucursalDTO>> listarPorEmpresaSeguridad(Long idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseGeneric<String> modificarUbicacionSucursal(Long idCliente, String lantitud, String longitud)
			throws SRSException {
		// TODO Auto-generated method stub
		return null;
	}

}
