package com.info.tpi.spring.gestion_recetas.presentation.dto.paso;

import com.info.tpi.spring.gestion_recetas.presentation.dto.ingrediente.IngredienteCreateDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record PasoCreateDto(
        @NotBlank(message = "La descripción del paso no puede estar vacía.")
        String descripcion,
        @Min(value = 0, message = "El tiempo estimado del paso no puede ser negativo.")
        int tiempoEstimado,
        boolean esOpcional,
        List<IngredienteCreateDto> ingredientes) {
}
