package com.info.tpi.spring.gestion_recetas.presentation.dto.categoria;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CategoriaCreateDto(
        @NotNull(message = "El nombre de la categoria no puede ser nulo.")
        @Size(max = 255, message = "El nombre de la categoria no puede ser mayor a 255 caracteres.")
        String nombre){
}
