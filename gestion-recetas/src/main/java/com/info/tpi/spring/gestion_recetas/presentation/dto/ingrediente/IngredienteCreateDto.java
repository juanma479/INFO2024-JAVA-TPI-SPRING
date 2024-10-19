package com.info.tpi.spring.gestion_recetas.presentation.dto.ingrediente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record IngredienteCreateDto(
        @NotBlank(message = "El nombre del ingrediente no puede estar vacio.")
        String nombre,
        @NotBlank
        @Size(max = 500, message = "La descripcion del ingrediente no puede superar los 500 caracteres.")
        String descripcion) {
}
