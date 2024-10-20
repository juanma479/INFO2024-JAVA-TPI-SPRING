package com.info.tpi.spring.gestion_recetas.presentation.dto.paso;

import com.info.tpi.spring.gestion_recetas.presentation.dto.ingrediente.IngredienteDto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(
        name = "DTO para respuestas de actualización de pasos."
)
public record PasoUpdatedDto(

        @Schema(description = "Id del paso.", example = "17")
        Long id,
        @Schema(description = "Descripción del paso.", example = "Batir claras hasta punto nieve.")
        String descripcion,
        @Schema(description = "Tiempo estimado en minutos que lleva realziar el paso.", example = "20")
        int TiempoEstimado,
        @Schema(description = "Atributo de tipo boolean para indicar si un paso es opcional.")
        boolean esOpcional,
        @Schema(description = "Lista de ingredientes en formato DTO involucrados en el paso")
        List<IngredienteDto> ingredientes) {
}
