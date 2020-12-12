package com.utn.frba.srs.infraestructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.utn.frba.srs.domain.exception.SRSException;

public interface QueryReportController {
	
	@GetMapping(path = "/reporte/idRondaEjecucion/{idRondaEjecucion}")
	public void obtenerRondaEjecucionEstadistica(@PathVariable("idRondaEjecucion") Long idRondaEjecucion) throws SRSException;

	@GetMapping(path = "/reporte/idSucursal/{idSucursal}")
	public void listarIndicadoresRondasSucursales(@PathVariable("idSucursal") Long idSucursal) throws SRSException;
}
