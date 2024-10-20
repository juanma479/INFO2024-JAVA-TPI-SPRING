package com.info.tpi.spring.gestion_recetas.presentation.dto.ingrediente;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "DTO de ingrediente para respuestas."
)
public record IngredienteDto(

        @Schema(description = "Id del ingrediente.", example = "4")
        Long id,
        @Schema(description = "Nombre del ingrediente.", example = "Harina")
        String nombre) {
}
