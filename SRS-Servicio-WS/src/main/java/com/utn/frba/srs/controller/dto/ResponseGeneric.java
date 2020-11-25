package com.utn.frba.srs.controller.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResponseGeneric<D> implements Serializable{

	private static final long serialVersionUID = 1L;

	private Header header;

	private D data;

	@Data
	public static class Header implements Serializable{

		private static final long serialVersionUID = 1L;

		private String severidad;
		private String codigo;
		private String descripcion;
	}
}
