package com.utn.fbra.srs.shared.domain;

public class ResultadoEDConsumer {

	private TipoEjecucion tipoEjecucion;
	private String mensaje;

	private ResultadoEDConsumer(TipoEjecucion tipoEjecucion, String mensaje) {
		super();
		this.tipoEjecucion = tipoEjecucion;
		this.mensaje = mensaje;
	}
	
	public static ResultadoEDConsumer ok() {
		return new ResultadoEDConsumer(TipoEjecucion.OK, null);
	}
	
	public static ResultadoEDConsumer error(String mensaje) {
		return new ResultadoEDConsumer(TipoEjecucion.ERROR, mensaje);
	}
	public static ResultadoEDConsumer reintentar(String mensaje) {
		return new ResultadoEDConsumer(TipoEjecucion.REINTENTAR, mensaje);
	}

}
