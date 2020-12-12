package com.utn.frba.srs.infraestructure.controller.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class RolUsuarioDTO {
	private Long id;

	@NotNull
	@Size(max = 25)
	private String name;

	@NotNull
	@Size(max = 125)
	private String description;
}
