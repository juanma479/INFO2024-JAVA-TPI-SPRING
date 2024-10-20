package com.info.tpi.spring.gestion_recetas.presentation.dto.categoria;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(
        name = "DTO de categoría para respuestas."
)
public record CategoriaDto(
        @Schema(description = "Id de la categoría.", example = "123e4567-e89b-12d3-a456-426655440000")UUID id,
        @Schema(description = "Nombre de la categoría.", example = "Pastas") String nombre) {
}
