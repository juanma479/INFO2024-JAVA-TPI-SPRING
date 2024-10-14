package com.info.tpi.spring.gestion_recetas.presentation.dto.receta;

import com.info.tpi.spring.gestion_recetas.persistance.domain.enums.DificultadEnum;
import com.info.tpi.spring.gestion_recetas.presentation.dto.categoria.CatgoriaDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.paso.PasoDto;

import java.util.List;
import java.util.UUID;

public record RecetaDto(UUID id,
                        String nombre,
                        String descripcion,
                        DificultadEnum dificultad,
                        CatgoriaDto categoria,
                        List<PasoDto> pasos) {
}
