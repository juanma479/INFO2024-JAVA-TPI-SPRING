package com.info.tpi.spring.gestion_recetas.presentation.dto.receta;

import com.info.tpi.spring.gestion_recetas.presentation.dto.categoria.CategoriaCreateDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RecetaRequestDto(
        @NotNull(message = "No se puede hacer la consulta con una receta nula.")
        @NotEmpty(message = "No se puede hacer la consulta con una receta vacía. ")
        RecetaCreateDto recetaCreateDto,
        @NotNull(message = "No se puede hacer la consulta con una categoría nula.")
        @NotEmpty(message = "No se puede hacer la consulta con una categoría vacía. ")
        CategoriaCreateDto categoriaCreateDto) {
}
