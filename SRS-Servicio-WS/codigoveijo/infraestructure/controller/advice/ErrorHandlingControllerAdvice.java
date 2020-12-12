package com.utn.frba.srs.infraestructure.controller.advice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.utn.frba.srs.shared.domain.SRSException;

@ControllerAdvice
public class ErrorHandlingControllerAdvice {

	@ExceptionHandler(SRSException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ValidationErrorResponse handleSRSException(SRSException ex) {
		ValidationErrorResponse error = new ValidationErrorResponse();
		error.getErrors().add(new ErrorHandling("98", "Error", "", "", ex.getMessage()));
		return error;

	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ValidationErrorResponse handleException(Exception ex, HttpServletRequest request) {
		ValidationErrorResponse error = new ValidationErrorResponse();

		if (ex.getCause() != null && ex.getCause().getCause() != null) {
			error.getErrors().add(new ErrorHandling("98", "Error", ex.getCause().getCause().getClass().toString(), "",
					ex.getCause().getCause().getMessage()));
		} else if (ex.getCause() != null) {
			error.getErrors().add(new ErrorHandling("98", "Error", ex.getCause().getClass().toString(), "",
					ex.getCause().getMessage()));
		}

		return error;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	ValidationErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		ValidationErrorResponse error = new ValidationErrorResponse();
		for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
			error.getErrors()
					.add(new ErrorHandling("98", "Error", "", fieldError.getField(), fieldError.getDefaultMessage()));
		}
		return error;
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	ValidationErrorResponse onConstraintValidationException(ConstraintViolationException e) {
		ValidationErrorResponse error = new ValidationErrorResponse();
		for (ConstraintViolation violation : e.getConstraintViolations()) {
			error.getErrors().add(new ErrorHandling("98", "Error", "Error de constraint de datos.",
					violation.getPropertyPath().toString(), violation.getMessage()));
		}
		return error;
	}

	@ExceptionHandler(InvalidDataAccessApiUsageException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	ValidationErrorResponse handleConstraintViolationExceptions(InvalidDataAccessApiUsageException ex) {
		ValidationErrorResponse error = new ValidationErrorResponse();

		if ((org.hibernate.TransientPropertyValueException) ex.getCause()
				.getCause() instanceof org.hibernate.TransientPropertyValueException) {

			org.hibernate.TransientPropertyValueException transientPropertyValueException = ((org.hibernate.TransientPropertyValueException) ex
					.getCause().getCause());

			error.getErrors()
					.add(new ErrorHandling("98", "Error", "Error al guardar los datos.",
							transientPropertyValueException.getPropertyName(),
							"Error de Constraint. No existe el valor informado en la tabla "
									+ transientPropertyValueException.getTransientEntityName()
									+ ". Esto impide guardar el registro en la tabla "
									+ transientPropertyValueException.getPropertyOwnerEntityName()));
		}
		return error;
	}
}
