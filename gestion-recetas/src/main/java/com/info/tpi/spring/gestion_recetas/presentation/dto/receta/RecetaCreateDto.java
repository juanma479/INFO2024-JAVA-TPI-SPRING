package com.info.tpi.spring.gestion_recetas.presentation.dto.receta;

import com.info.tpi.spring.gestion_recetas.persistance.domain.enums.DificultadEnum;
import com.info.tpi.spring.gestion_recetas.presentation.dto.paso.PasoCreateDto;
import jakarta.validation.constraints.Null;

import java.util.List;
import java.util.UUID;

public record RecetaCreateDto(
        String nombre,
        String descripcion,
        DificultadEnum dificultad,
        @Null
        UUID idCategoria,
        List<PasoCreateDto> pasos
) {
}
