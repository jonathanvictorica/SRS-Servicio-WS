package com.utn.frba.srs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.utn.frba.srs.controller.dto.RequestGeneric;
import com.utn.frba.srs.controller.dto.ResponseGeneric;
import com.utn.frba.srs.controller.dto.SucursalDTO;
import com.utn.frba.srs.exception.SRSException;

public interface AdmSubsidiaryController {

	@PostMapping(path = "/sucursal")
	public void crear(@RequestBody RequestGeneric<SucursalDTO> request) throws SRSException;

	@PutMapping(path = "/sucursal")
	public void modificar(@RequestBody RequestGeneric<SucursalDTO> request) throws SRSException;

	@DeleteMapping(path = "/sucursal/{id}")
	public void eliminar(@PathVariable("id") Long id) throws SRSException;

	@GetMapping(path = "/sucursal/{id}")
	public ResponseGeneric<SucursalDTO> obtenerPorId(@PathVariable("id") Long id) throws SRSException;

	@GetMapping(path = "/sucursal/{idCliente}/{nombre}")
	public ResponseGeneric<SucursalDTO> obtenerPorIdClientePorNombre(@PathVariable("idCliente") Long idCliente,
			@PathVariable("nombre") String nombre) throws SRSException;

	@GetMapping(path = "/sucursales/{idCliente}")
	public ResponseGeneric<List<SucursalDTO>> listarPorEmpresaSeguridad(@PathVariable("idCliente") Long idCliente);

	@PutMapping(path = "/sucursal/{idSucursal}/{lantitud}/{longitud}")
	public ResponseGeneric<String> modificarUbicacionSucursal(@PathVariable("idSucursal") Long idCliente,
			@PathVariable("lantitud") String lantitud, @PathVariable("longitud") String longitud) throws SRSException;

}
