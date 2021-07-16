package com.gabrielpedrico.proposta.proposta.handlers.outputs;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FieldErrorOutput {

    private String field;
    private String message;

    @Deprecated
    FieldErrorOutput() {
    }

    public FieldErrorOutput(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
