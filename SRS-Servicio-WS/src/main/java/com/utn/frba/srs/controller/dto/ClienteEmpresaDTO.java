package com.utn.frba.srs.controller.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ClienteEmpresaDTO {
	@NotNull
	@Size(max = 100)
	@Column(nullable = false)
	private String razonSocial;

	@NotNull
	@Size(max = 4)
	@Column(nullable = false)
	private String tipoDocumento;

	@NotNull
	@Size(max = 15)
	@Column(nullable = false)
	private String nroDocumento;
}
