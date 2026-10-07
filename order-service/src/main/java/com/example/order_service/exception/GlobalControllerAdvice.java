package com.example.order_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.net.URI;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ProblemDetail handleResourceNotFoundException(ResourceNotFoundException exception){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());

        problemDetail.setTitle("Recurso no encontrado");
        problemDetail.setType(URI.create("https://api.ecommerce.com/v1/order/errors/not-found"));
        problemDetail.setProperty("Timestamp", Instant.now());

        problemDetail.setProperty("Resource", exception.getResourceName());
        problemDetail.setProperty("Field", exception.getFieldName());
        problemDetail.setProperty("Value", exception.getFieldValue());

        return problemDetail;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
                "la validación falló en uno o más campos.");

        problemDetail.setTitle("Error de validación");
        problemDetail.setType(URI.create("https://api.ecommerce.com/v1/order/errors/errors/error-validation"));
        problemDetail.setProperty("Timestamp", Instant.now());

        Map<String, String> errorMap = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(
                error ->{
                    errorMap.put(error.getField(), error.getDefaultMessage());
                }
        );

        problemDetail.setProperty("errors", errorMap);

        return problemDetail;
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleException(Exception exception, WebRequest request){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
                "Ha ocurrido un error inesperado. Por favor intente nuevamente.");

        problemDetail.setTitle("internal server error");
        problemDetail.setType(URI.create("https://api.ecommerce.com/v1/order/errors/error/"));
        problemDetail.setProperty("Timestamp", Instant.now());

        return problemDetail;
    }
}
