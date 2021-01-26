package com.utn.fbra.srs.domain.vo;

import java.sql.Time;
import java.util.Date;

import com.utn.fbra.srs.shared.domain.ValueObject;

public class FechaHoraVO extends ValueObject {

	private Date fecha;
	private Time hora;

	public FechaHoraVO(Date fecha, Time hora) {
		super();
		this.fecha = fecha;
		this.hora = hora;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

}
