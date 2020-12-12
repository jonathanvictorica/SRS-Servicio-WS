package com.utn.frba.srs.infraestructure.controller.advice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorHandling {

	private String code;

	private String severity;

	private String message;

	private String fieldName;

	private String details;

}
