package com.info.tpi.spring.gestion_recetas.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private HttpStatus status;

    private String message;

    private String timestamp;

    private String path;
}
