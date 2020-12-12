package com.utn.frba.srs.infraestructure.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.frba.srs.infraestructure.controller.QueryReportController;
import com.utn.frba.srs.shared.domain.SRSException;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "/v1")
@Api(tags = "ConsultaReporte", description = ("ConsultaReporte"))
public class ConsultaReporteControllerImpl extends GenericWS
		implements QueryReportController {

	@Override
	public void obtenerRondaEjecucionEstadistica(Long idRondaEjecucion) throws SRSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarIndicadoresRondasSucursales(Long idSucursal) throws SRSException {
		// TODO Auto-generated method stub
		
	}


}
