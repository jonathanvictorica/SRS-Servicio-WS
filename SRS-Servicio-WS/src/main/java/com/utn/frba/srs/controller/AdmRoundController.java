package com.utn.frba.srs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.utn.frba.srs.controller.dto.RequestGeneric;
import com.utn.frba.srs.controller.dto.ResponseGeneric;
import com.utn.frba.srs.controller.dto.RondaDTO;
import com.utn.frba.srs.exception.SRSException;

public interface AdmRoundController {

	@PostMapping(path = "/ronda")
	public void crear(@RequestBody RequestGeneric<RondaDTO> request) throws SRSException;

	@DeleteMapping(path = "/ronda")
	public void eliminar(@PathVariable("id") Long id) throws SRSException;

	@GetMapping(path = "/ronda/{id}")
	public ResponseGeneric<RondaDTO> obtenerPorId(@PathVariable("id") Long id) throws SRSException;

	@GetMapping(path = "/rondas/{idSucursal}")
	public ResponseGeneric<List<RondaDTO>> listarPorSucursal(@PathVariable("idSucursal") Long idSucursal)
			throws SRSException;

	@GetMapping(path = "/ronda/{idSucursal}/{nombreRonda}")
	public ResponseGeneric<RondaDTO> obtenerPorSucursalPorNombreRonda(@PathVariable("idSucursal") Long idSucursal,
			@PathVariable("nombreRonda") String nombreRonda) throws SRSException;

	@GetMapping(path = "/ronda/{idEmpresaSeguridad}")
	public ResponseGeneric<List<RondaDTO>> listarPorEmpresa(
			@PathVariable("idEmpresaSeguridad") Long idEmpresaSeguridad) throws SRSException;

}
