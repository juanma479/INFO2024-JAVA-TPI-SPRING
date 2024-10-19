package com.info.tpi.spring.gestion_recetas.presentation.dto.receta;

import com.info.tpi.spring.gestion_recetas.persistance.domain.enums.DificultadEnum;
import com.info.tpi.spring.gestion_recetas.presentation.dto.paso.PasoCreateDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

public record RecetaCreateDto(
        @NotNull(message = "El nombre de la receta no puede ser nulo.")
        @Size(max = 255, message = "El nombre de la receta no puede superar los 255 caracteres.")
        @NotEmpty(message = "El nombre de la receta no puede estar vacío.")
        String nombre,
        @NotNull(message = "La descripcion de la receta no puede ser nula.")
        @Size(max = 5000, message = "La descripción de la receta no puede superar los 5000 caracteres.")
        @NotEmpty(message = "La descripción de la receta no puede estar vacía.")
        String descripcion,
        DificultadEnum dificultad,
        @Null
        UUID idCategoria,
        List<PasoCreateDto> pasos
) {
}
