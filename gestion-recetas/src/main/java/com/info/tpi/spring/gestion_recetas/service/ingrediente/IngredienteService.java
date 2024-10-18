package com.info.tpi.spring.gestion_recetas.service.ingrediente;

import com.info.tpi.spring.gestion_recetas.presentation.dto.ingrediente.IngredienteDto;

import java.util.List;
import java.util.UUID;

public interface IngredienteService {

    List<IngredienteDto> getIngredientesOfReceta(UUID idReceta, Long idPaso);
}
