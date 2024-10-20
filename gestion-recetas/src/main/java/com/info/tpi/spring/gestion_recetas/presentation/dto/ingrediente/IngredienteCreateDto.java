package com.info.tpi.spring.gestion_recetas.presentation.dto.ingrediente;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(
        name = "DTO para crear un ingrediente"
)
public record IngredienteCreateDto(
        @NotBlank(message = "El nombre del ingrediente no puede estar vacio.")
        @Schema(description = "Nombre del ingrediente.", example = "Harina")
        String nombre,
        @NotBlank
        @Size(max = 500, message = "La descripcion del ingrediente no puede superar los 500 caracteres.")
        @Schema(description = "Descripción del ingrediente.", example = "Media taza de harina.")
        String descripcion) {
}
