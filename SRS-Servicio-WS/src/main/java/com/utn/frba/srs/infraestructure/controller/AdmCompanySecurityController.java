package com.utn.frba.srs.infraestructure.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.utn.frba.srs.domain.exception.SRSException;
import com.utn.frba.srs.infraestructure.controller.dto.EmpresaDTO;
import com.utn.frba.srs.infraestructure.controller.dto.RequestGeneric;
import com.utn.frba.srs.infraestructure.controller.dto.ResponseGeneric;

public interface AdmCompanySecurityController {
	@PostMapping(path = "/empresa")
	public void crear(@RequestBody RequestGeneric<EmpresaDTO> request) throws SRSException;

	@PutMapping(path = "/empresa")
	public void modificar(@RequestBody RequestGeneric<EmpresaDTO> request) throws SRSException;

	@DeleteMapping(path = "/empresa/{id}")
	public void eliminar(@PathVariable("id") Long id) throws SRSException;

	@GetMapping(path = "/empresa/{id}")
	public ResponseGeneric<EmpresaDTO> obtenerPorId(@PathVariable("id") Long id) throws SRSException;
	
	@GetMapping(path = "/empresa/{documento}")
	public ResponseGeneric<EmpresaDTO> obtenerPorDocumento(@PathVariable("documento") String documento) throws SRSException;
	
	@GetMapping(path = "/empresas")
	public ResponseGeneric<List<EmpresaDTO>> listarEmpresas() throws SRSException;

	
}
