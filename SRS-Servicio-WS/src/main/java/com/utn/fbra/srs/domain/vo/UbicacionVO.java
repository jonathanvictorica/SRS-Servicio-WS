package com.utn.fbra.srs.domain.vo;

import com.utn.fbra.srs.shared.domain.ValueObject;

public class UbicacionVO extends ValueObject{

	private String latitud;
	private String longitud;

	public UbicacionVO(String latitud, String longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	
	

}
