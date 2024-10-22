package com.info.tpi.spring.gestion_recetas.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private HttpStatus status;

    private String message;

    private String timestamp;

    private String path;

    private List<String> errors;
}
