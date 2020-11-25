package com.utn.frba.srs.controller.advice;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ValidationErrorResponse {

	private List<ErrorHandling> errors = new ArrayList<>();

}