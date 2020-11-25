package com.utn.frba.srs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.utn.frba.srs.controller.dto.ClienteEmpresaDTO;
import com.utn.frba.srs.controller.dto.RequestGeneric;
import com.utn.frba.srs.controller.dto.ResponseGeneric;
import com.utn.frba.srs.exception.SRSException;

import io.swagger.annotations.ApiOperation;

public interface AdmCompanyClientController {
	@PostMapping(path = "/clienteEmpresa")
	@ApiOperation(value = "crear")
	public void crear(@RequestBody RequestGeneric<ClienteEmpresaDTO> request) throws SRSException;

	@PutMapping(path = "/clienteEmpresa")
	@ApiOperation(value = "modificar")
	public void modificar(@RequestBody RequestGeneric<ClienteEmpresaDTO> request) throws SRSException;

	@DeleteMapping(path = "/clienteEmpresa/{id}")
	@ApiOperation(value = "eliminar")
	public void eliminar(@PathVariable("id") Long id) throws SRSException;

	@GetMapping(path = "/clienteEmpresa/{id}")
	public ResponseGeneric<ClienteEmpresaDTO> obtenerPorId(@PathVariable("id") Long id) throws SRSException;

	@GetMapping(path = "/clienteEmpresa")
	public ResponseGeneric<ClienteEmpresaDTO> obtenerPorDocumentoYEmpresa(@PathVariable("documento") String documento,
			@PathVariable("idEmpresa") Long idEmpresa) throws SRSException;

	@GetMapping(path = "/clienteEmpresa/idEmpresa/{idEmpresa}")
	public ResponseGeneric<List<ClienteEmpresaDTO>> listarPorEmpresaSeguridad(
			@PathVariable("idEmpresa") Long idEmpresa) throws SRSException;
}
