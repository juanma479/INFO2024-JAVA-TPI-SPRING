package com.info.tpi.spring.gestion_recetas.presentation.dto.paso;

import com.info.tpi.spring.gestion_recetas.presentation.dto.ingrediente.IngredienteCreateDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Schema(
        name = "DTO para realizar cambios en un paso de receta."
)
public record PasoChangeDto(
        @NotBlank(message = "La descripcion del paso no puede estar vacía.")
        @Schema(description = "Descripción del paso.", example = "Agregar la harina tamizada y amasar.")
        String descripcion,
        @Min(value = 0, message = "El tiempo estimado del paso no puede ser negativo.")
        @Schema(description = "El tiempo estimado  en minutos que toma realizar el paso.", example = "20")
        int tiempoEstimado,
        @Schema(description = "Atributo de tipo boolean que indica si el paso es opcional o no.")
        boolean esOpcional,
        @Schema(description = "Lista de ingredientes en formato DTO involucrados en el paso.")
        List<IngredienteCreateDto> ingredientes) {
}
