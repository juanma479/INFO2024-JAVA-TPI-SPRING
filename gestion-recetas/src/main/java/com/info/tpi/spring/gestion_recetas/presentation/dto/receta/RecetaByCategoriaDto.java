package com.info.tpi.spring.gestion_recetas.presentation.dto.receta;

import com.info.tpi.spring.gestion_recetas.persistance.domain.enums.DificultadEnum;

import java.util.UUID;

public record RecetaByCategoriaDto(UUID id,
                                   String nombre,
                                   DificultadEnum dificultad,
                                   String descripcion,
                                   int tiempoTotal) {
}
