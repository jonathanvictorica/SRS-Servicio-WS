package com.utn.frba.srs.infraestructure.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.utn.frba.srs.infraestructure.controller.dto.CheckpointDTO;
import com.utn.frba.srs.infraestructure.controller.dto.RequestGeneric;
import com.utn.frba.srs.infraestructure.controller.dto.ResponseGeneric;
import com.utn.frba.srs.shared.domain.SRSException;

public interface AdmCheckpointController {

	@PostMapping(path = "/checkpoint")
	public void crear(@RequestBody RequestGeneric<CheckpointDTO> request) throws SRSException;

	@DeleteMapping(path = "/checkpoint/{id}")
	public void eliminar(@PathVariable("id") Long id) throws SRSException;

	@GetMapping(path = "/checkpoint/idSucursal/{idSucursal}")
	public ResponseGeneric<List<CheckpointDTO>> listarPorSucursal(@PathVariable("idSucursal") Long idSucursal)
			throws SRSException;

}
