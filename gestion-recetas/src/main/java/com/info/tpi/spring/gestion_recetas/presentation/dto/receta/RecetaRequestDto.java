package com.info.tpi.spring.gestion_recetas.presentation.dto.receta;

import com.info.tpi.spring.gestion_recetas.presentation.dto.categoria.CategoriaCreateDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(
        name = "DTO utlizado para hacer una consulta de creación de receta."
)
public record RecetaRequestDto(
        @NotNull(message = "No se puede hacer la consulta con una receta nula.")
        @Schema(description = "Receta en formato DTO con datos para la creación de la receta.")
        RecetaCreateDto recetaCreateDto,
        @NotNull(message = "No se puede hacer la consulta con una categoría nula.")
        @Schema(description = "Categoría en formato DTO con datos para la creación de la categoría de ser necesario.")
        CategoriaCreateDto categoriaCreateDto) {
}
