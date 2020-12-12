package com.utn.frba.srs.infraestructure.controller.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;

	@NotNull
	@Size(max = 50)
	private String name;

	@NotNull
	@Size(max = 50)
	private String lastName;

	@NotNull
	@Size(max = 4)
	private String documentType;

	@NotNull
	@Size(max = 15)
	private String documentNumber;

	@NotNull
	@Size(max = 150)
	private String mail = "";
	
	@NotNull
	@Size(max = 50)
	private String nick;
	
	@NotNull
	private List<String> roles;
	
	@NotNull
	private Long companyId;
}
