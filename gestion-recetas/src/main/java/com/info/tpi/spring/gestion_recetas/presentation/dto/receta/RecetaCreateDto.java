package com.info.tpi.spring.gestion_recetas.presentation.dto.receta;

import com.info.tpi.spring.gestion_recetas.persistance.domain.enums.DificultadEnum;
import com.info.tpi.spring.gestion_recetas.presentation.dto.paso.PasoCreateDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

@Schema(
        name = "DTO para la creación de una receta."
)
public record RecetaCreateDto(
        @NotNull(message = "El nombre de la receta no puede ser nulo.")
        @Size(max = 255, message = "El nombre de la receta no puede superar los 255 caracteres.")
        @NotEmpty(message = "El nombre de la receta no puede estar vacío.")
        @Schema(description = "Nombre de la receta.", example = "Spagetti carbonara")
        String nombre,
        @NotNull(message = "La descripcion de la receta no puede ser nula.")
        @Size(max = 5000, message = "La descripción de la receta no puede superar los 5000 caracteres.")
        @NotEmpty(message = "La descripción de la receta no puede estar vacía.")
        @Schema(description = "Descripción de la receta.", example = "Receta original del spagetti con salsa carbonara.")
        String descripcion,
        @Schema(description = "Dificultad de la receta.", example = "MEDIA")
        DificultadEnum dificultad,
        @Null
        @Schema(description = "Id de la caegoría a la que pertenecería la receta, puede ser null.",
                example = "123e4567-e89b-12d3-a456-426655440000")
        UUID idCategoria,
        @Schema(description = "Lista de los pasos en formato DTO que forman parte de la receta." )
        List<PasoCreateDto> pasos
) {
}
