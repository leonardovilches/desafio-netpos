package com.desafio.netpos.backend.controller.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends GenericError {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(Integer status, String message) {
		super(status, message);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}
	
	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}

}
