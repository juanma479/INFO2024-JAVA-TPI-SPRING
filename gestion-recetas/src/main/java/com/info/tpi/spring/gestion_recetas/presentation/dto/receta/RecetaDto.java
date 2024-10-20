package com.info.tpi.spring.gestion_recetas.presentation.dto.receta;

import com.info.tpi.spring.gestion_recetas.persistance.domain.enums.DificultadEnum;
import com.info.tpi.spring.gestion_recetas.presentation.dto.categoria.CategoriaDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.paso.PasoDto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.UUID;

@Schema(
        name = "DTO de receta para respuestas."
)
public record RecetaDto(
        @Schema(description = "Id de la receta.", example = "123e4567-e89b-12d3-a456-426655440000")
        UUID id,
        @Schema(description = "Nombre de la receta.", example = "Pollo frito picante")
        String nombre,
        @Schema(description = "Descripción de la receta.", example = "Receta de pollo frito casero con salsa picante.")
        String descripcion,
        @Schema(description = "Dificultad de la receta.", example = "MEDIA")
        DificultadEnum dificultad,
        @Schema(description = "Categoría a la que pertenece dicha receta.")
        CategoriaDto categoria,
        @Schema(description = "Lista de pasos en formato DTO involucrados en la receta.")
        List<PasoDto> pasos) {
}
