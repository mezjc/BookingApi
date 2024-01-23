package org.jmez.bookingapi.handler;

import org.jmez.bookingapi.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.RecursiveTask;

@RestControllerAdvice
public class RestExceptionHandler {

    private final MessageSource messageSource;

    public RestExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ProblemDetail handleValidationError(MethodArgumentNotValidException manve){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        problemDetail.setTitle("Unprocessable Entity");
        problemDetail.setDetail("The entity can't processed because it has errors.");

        Set<String> errors = new HashSet<>();
        List<FieldError> fieldError = manve.getFieldErrors();

        for (FieldError fe : fieldError){
            String message = messageSource.getMessage(fe, Locale.getDefault());
            errors.add(message);
        }
        problemDetail.setProperty("errors", errors);
        return problemDetail;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    ProblemDetail handlerResourceNotFoundException(ResourceNotFoundException foundException){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, foundException.getMessage());
        problemDetail.setTitle("RESOURCE NOT FOUND");
        return problemDetail;

    }
}
