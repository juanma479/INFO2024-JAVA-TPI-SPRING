package com.info.tpi.spring.gestion_recetas.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.LazyInitializationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex,
                                                                         HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                LocalDateTime.now().toString(),
                request.getRequestURI(),
                null
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException ex,
                                                                   HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                LocalDateTime.now().toString(),
                request.getRequestURI(),
                null
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponse> handleConflictException(ConflictException ex,
                                                                 HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.CONFLICT,
                ex.getMessage(),
                LocalDateTime.now().toString(),
                request.getRequestURI(),
                null);
        return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex,
                                                                   HttpServletRequest request) {

        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": "+error.getDefaultMessage()).toList();

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                "Error de Validación",
                LocalDateTime.now().toString(),
                request.getRequestURI(),
                errors
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ErrorResponse> handleInternalServerErrorException(InternalServerErrorException ex,
                                                                            HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(),
                LocalDateTime.now().toString(),
                request.getRequestURI(),
                null
                );
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DuplicateDataException.class)
    public ResponseEntity<ErrorResponse> handleDuplicatedDataException(DuplicateDataException ex,
                                                                       HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.CONFLICT,
                ex.getMessage(),
                LocalDateTime.now().toString(),
                request.getRequestURI(),
                null
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex,
                                                                        HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                "Valor de argumento no válido",
                LocalDateTime.now().toString(),
                request.getRequestURI(),
                null
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LazyInitializationException.class)
    public ResponseEntity<ErrorResponse> handleLazyInitializationException(LazyInitializationException ex,
                                                                           HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                LocalDateTime.now().toString(),
                request.getRequestURI(),
                null
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception exception,
                                                               HttpServletRequest request) {
        ErrorResponse errorResponse =new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Un error inesperado ha ocurrido.",
                LocalDateTime.now().toString(),
                request.getRequestURI(),
                null
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
