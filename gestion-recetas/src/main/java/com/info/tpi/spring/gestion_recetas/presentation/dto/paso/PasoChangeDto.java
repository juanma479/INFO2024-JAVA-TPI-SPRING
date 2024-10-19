package com.info.tpi.spring.gestion_recetas.presentation.dto.paso;

import com.info.tpi.spring.gestion_recetas.presentation.dto.ingrediente.IngredienteCreateDto;

import java.util.List;

public record PasoChangeDto(Long idPaso,
                            String descripcion,
                            int tiempoEstimado,
                            boolean esOpcional,
                            List<IngredienteCreateDto> ingredientes) {
}