package com.info.tpi.spring.gestion_recetas.presentation.dto.categoria;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(
        name = "DTO para crear una categoría."
)
public record CategoriaCreateDto(
        @NotNull(message = "El nombre de la categoria no puede ser nulo.")
        @Size(max = 255, message = "El nombre de la categoria no puede ser mayor a 255 caracteres.")
        @Schema(description = "Nombre de la categoría.", example = "Pastas") String nombre){
}
