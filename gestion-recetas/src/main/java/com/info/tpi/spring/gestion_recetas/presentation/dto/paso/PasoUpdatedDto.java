package com.info.tpi.spring.gestion_recetas.presentation.dto.paso;

import com.info.tpi.spring.gestion_recetas.presentation.dto.ingrediente.IngredienteDto;

import java.util.List;

public record PasoUpdatedDto(Long id,
                             String descripcion,
                             int TiempoEstimado,
                             boolean esOpcional,
                             List<IngredienteDto> ingredientes) {
}
