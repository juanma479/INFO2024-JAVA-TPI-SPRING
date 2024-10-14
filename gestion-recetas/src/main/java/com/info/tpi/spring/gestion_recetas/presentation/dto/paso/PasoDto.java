package com.info.tpi.spring.gestion_recetas.presentation.dto.paso;

import com.info.tpi.spring.gestion_recetas.presentation.dto.ingrediente.IngredienteDto;

import java.util.List;

public record PasoDto(Long id,
                      int tiempoEstimado,
                      List<IngredienteDto> ingredientes) {
}
