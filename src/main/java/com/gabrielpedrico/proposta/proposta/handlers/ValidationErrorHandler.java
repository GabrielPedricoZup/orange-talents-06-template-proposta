package com.gabrielpedrico.proposta.proposta.handlers;

import com.gabrielpedrico.proposta.proposta.handlers.outputs.FieldErrorOutput;
import com.gabrielpedrico.proposta.proposta.handlers.outputs.ValidationErrorsOutput;
import com.gabrielpedrico.proposta.proposta.models.Proposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestControllerAdvice
public class ValidationErrorHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorsOutput handleValidationError(MethodArgumentNotValidException exception) {

        List<ObjectError> globalErrors = exception.getBindingResult().getGlobalErrors();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        return buildValidationErrors(globalErrors, fieldErrors);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public FieldErrorOutput handleValidationError(IllegalArgumentException exception) {

       return new FieldErrorOutput(null, exception.getMessage());

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ValidationErrorsOutput handleValidationError(BindException exception) {

        List<ObjectError> globalErrors = exception.getBindingResult().getGlobalErrors();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        return buildValidationErrors(globalErrors, fieldErrors);
    }

    private ValidationErrorsOutput buildValidationErrors(List<ObjectError> globalErrors, List<FieldError> fieldErrors) {

        ValidationErrorsOutput validationErrors = new ValidationErrorsOutput();

        globalErrors.forEach(error -> validationErrors.addError(getErrorMessage(error)));

        fieldErrors.forEach(error -> {
            String errorMessage = getErrorMessage(error);
            validationErrors.addFieldError(error.getField(), errorMessage);
        });

        return validationErrors;



    }

    private String getErrorMessage(ObjectError error) {
        return messageSource.getMessage(error, LocaleContextHolder.getLocale());
    }

    private Proposta teste(Boolean v, Proposta proposta){
        if(v) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "DataFim:");
        }
        return proposta;
    }
}