package com.info.tpi.spring.gestion_recetas.presentation.dto.receta;

import com.info.tpi.spring.gestion_recetas.presentation.dto.categoria.CategoriaCreateDto;

public record RecetaRequestDto(RecetaCreateDto recetaCreateDto,
                               CategoriaCreateDto categoriaCreateDto) {
}
