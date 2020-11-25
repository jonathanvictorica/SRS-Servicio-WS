package com.utn.frba.srs.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.controller.AdmCompanySecurityController;
import com.utn.frba.srs.controller.dto.EmpresaDTO;
import com.utn.frba.srs.controller.dto.RequestGeneric;
import com.utn.frba.srs.controller.dto.ResponseGeneric;
import com.utn.frba.srs.exception.SRSException;
import com.utn.frba.srs.service.AdmSecurityCompanyUseCasePort;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "/v1")
@Api(tags = "AdministrarEmpresaSeguridadSeguridad", description = ("AdministrarEmpresaSeguridad"))
public class AdmEmpresaSeguridadControllerImpl extends GenericWS
		implements AdmCompanySecurityController {
	
	@Autowired
	private AdmSecurityCompanyUseCasePort admSecurityCompanyUseCasePort;
	

	@Override
	public void crear(RequestGeneric<EmpresaDTO> request) throws SRSException {
		admSecurityCompanyUseCasePort.create(request.getData());
		
	}

	@Override
	public void modificar(RequestGeneric<EmpresaDTO> request) throws SRSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) throws SRSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseGeneric<EmpresaDTO> obtenerPorId(Long id) throws SRSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseGeneric<EmpresaDTO> obtenerPorDocumento(String documento) throws SRSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseGeneric<List<EmpresaDTO>> listarEmpresas() throws SRSException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
