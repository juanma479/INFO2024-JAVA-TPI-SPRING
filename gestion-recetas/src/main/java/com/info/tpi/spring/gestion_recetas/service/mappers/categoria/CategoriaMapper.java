package com.info.tpi.spring.gestion_recetas.service.mappers.categoria;

import com.info.tpi.spring.gestion_recetas.persistance.domain.Categoria;
import com.info.tpi.spring.gestion_recetas.presentation.dto.categoria.CategoriaCreateDto;
import org.mapstruct.Mapper;

@Mapper
public interface CategoriaMapper {

    Categoria createDtoToEntity(CategoriaCreateDto categoriaCreateDto);
}
