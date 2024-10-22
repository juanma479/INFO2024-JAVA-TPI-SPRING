package com.info.tpi.spring.gestion_recetas.service.receta;

import com.info.tpi.spring.gestion_recetas.persistance.domain.Receta;
import com.info.tpi.spring.gestion_recetas.presentation.dto.categoria.CategoriaCreateDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.receta.RecetaCreateDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.receta.RecetaDto;

import java.util.UUID;

public interface RecetaService {

    RecetaDto createReceta(RecetaCreateDto recetaCreateDto, CategoriaCreateDto categoriaCreateDto);

    Receta getReceta(UUID idReceta);

    RecetaDto getRecetaById(UUID idReceta);

    boolean deleteReceta(UUID idReceta);

}
