package com.utn.frba.srs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.utn.frba.srs.controller.dto.CerrarIncidenteDTO;
import com.utn.frba.srs.controller.dto.IncidenteDTO;
import com.utn.frba.srs.controller.dto.RequestGeneric;
import com.utn.frba.srs.controller.dto.ResponseGeneric;
import com.utn.frba.srs.controller.dto.SeveridadDTO;
import com.utn.frba.srs.exception.SRSException;

public interface AdmIncidentController {

	@PostMapping(path = "/incidente")
	public void crear(@RequestBody RequestGeneric<IncidenteDTO> request) throws SRSException;

	@PutMapping(path = "/incidente")
	public void cerrarIncidente(@RequestBody RequestGeneric<CerrarIncidenteDTO> request) throws SRSException;

	@GetMapping(path = "/incidente/{id}")
	public ResponseGeneric<IncidenteDTO> obtenerPorId(@PathVariable("id") Long id) throws SRSException;

	@GetMapping(path = "/incidente/severidades")
	public ResponseGeneric<List<SeveridadDTO>> listarSeveridades() throws SRSException;
}
