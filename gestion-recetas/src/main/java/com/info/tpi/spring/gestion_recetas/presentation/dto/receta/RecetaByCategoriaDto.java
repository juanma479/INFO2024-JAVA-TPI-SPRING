package com.info.tpi.spring.gestion_recetas.presentation.dto.receta;

import com.info.tpi.spring.gestion_recetas.persistance.domain.enums.DificultadEnum;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(
        name = "DTO de receta para respuesta de busqueda de recetas dada una categoría."
)
public record RecetaByCategoriaDto(
        @Schema(description = "Id de la receta.", example = "123e4567-e89b-12d3-a456-426655440000")
        UUID id,
        @Schema(description = "Nombre de la receta.", example = "Cheesecake")
        String nombre,
        @Schema(description = "Dificuldad de la receta.", example = "BAJA")
        DificultadEnum dificultad,
        @Schema(description = "Descripción de la receta.", example = "Receta de cheesecake super facil.")
        String descripcion,
        @Schema(description = "Tiempo en minutos que lleva realizar la receta." +
                " Es la suma de los tiempos de sus pasos.", example = "60")
        int tiempoTotal) {
}
