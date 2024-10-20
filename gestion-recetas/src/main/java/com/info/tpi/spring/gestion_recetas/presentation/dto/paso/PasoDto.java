package com.info.tpi.spring.gestion_recetas.presentation.dto.paso;

import com.info.tpi.spring.gestion_recetas.presentation.dto.ingrediente.IngredienteDto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(
        name = "DTO de paso para respuestas"
)
public record PasoDto(
        @Schema(description = "Id del paso", example = "5")
        Long id,
        @Schema(description = "Tiempo estimado en minutos que lleva realizar el paso", example = "20")
        int tiempoEstimado,
        @Schema(description = "Lista de ingredientes en formato DTO involucrados en el paso.")
        List<IngredienteDto> ingredientes) {
}
