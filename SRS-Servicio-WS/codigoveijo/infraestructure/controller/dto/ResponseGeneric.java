package com.utn.frba.srs.infraestructure.controller.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ResponseGeneric<D> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Header header;

	private D data;

	public ResponseGeneric() {
		this.header = new Header("OK", "000", "Successful");
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Header implements Serializable {

		private static final long serialVersionUID = 1L;

		private String severity;
		private String code;
		private String details;
	}
}
