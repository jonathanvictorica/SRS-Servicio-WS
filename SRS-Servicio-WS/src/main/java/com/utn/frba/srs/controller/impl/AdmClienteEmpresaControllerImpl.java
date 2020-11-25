package com.utn.frba.srs.controller.impl;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.controller.AdmCompanyClientController;
import com.utn.frba.srs.controller.dto.ClienteEmpresaDTO;
import com.utn.frba.srs.controller.dto.RequestGeneric;
import com.utn.frba.srs.controller.dto.ResponseGeneric;
import com.utn.frba.srs.exception.SRSException;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "/v1")
@Api(tags = "AdministrarClienteEmpresaSeguridad", description = ("AdministrarClienteEmpresaSeguridad"))
public class AdmClienteEmpresaControllerImpl extends GenericWS
		implements AdmCompanyClientController {

	@Override
	public void crear(RequestGeneric<ClienteEmpresaDTO> request) throws SRSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(RequestGeneric<ClienteEmpresaDTO> request) throws SRSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) throws SRSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseGeneric<ClienteEmpresaDTO> obtenerPorId(Long id) throws SRSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseGeneric<ClienteEmpresaDTO> obtenerPorDocumentoYEmpresa(String documento, Long idEmpresa)
			throws SRSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseGeneric<List<ClienteEmpresaDTO>> listarPorEmpresaSeguridad(Long idEmpresa) throws SRSException {
		// TODO Auto-generated method stub
		return null;
	}


}
