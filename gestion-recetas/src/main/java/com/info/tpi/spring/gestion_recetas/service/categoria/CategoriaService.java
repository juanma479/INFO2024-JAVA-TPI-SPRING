package com.info.tpi.spring.gestion_recetas.service.categoria;

import com.info.tpi.spring.gestion_recetas.persistance.domain.Categoria;
import com.info.tpi.spring.gestion_recetas.presentation.dto.categoria.CategoriaCreateDto;

import java.util.UUID;

public interface CategoriaService {

    Categoria getOrCreateCategoria(UUID idCategoria, CategoriaCreateDto categoriaCreateDto);
}
