package com.utn.frba.srs.infraestructure.controller.dto;

import javax.validation.Valid;

import lombok.Data;

@Data
public class RequestGeneric<D> {

	@Valid
	private D data;

}
