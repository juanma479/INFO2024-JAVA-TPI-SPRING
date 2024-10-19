package com.info.tpi.spring.gestion_recetas.presentation.dto.receta;

import com.info.tpi.spring.gestion_recetas.persistance.domain.enums.DificultadEnum;
import com.info.tpi.spring.gestion_recetas.presentation.dto.categoria.CategoriaDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.paso.PasoDto;

import java.util.List;
import java.util.UUID;

public record RecetaDto(UUID id,
                        String nombre,
                        String descripcion,
                        DificultadEnum dificultad,
                        CategoriaDto categoria,
                        List<PasoDto> pasos) {
}
