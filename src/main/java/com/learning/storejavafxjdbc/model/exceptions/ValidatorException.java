package com.learning.storejavafxjdbc.model.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ValidatorException extends RuntimeException {

    private Map<String, String> errors = new HashMap<>();

    public ValidatorException(String message) {
        super(message);
    }

    public Map<String, String> getErrors () {
        return errors;
    }

    public void addError(String fieldName, String errorMessage) {
        errors.put(fieldName, errorMessage);
    }
}
