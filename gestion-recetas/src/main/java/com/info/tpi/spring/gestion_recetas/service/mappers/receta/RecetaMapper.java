package com.info.tpi.spring.gestion_recetas.service.mappers.receta;

import com.info.tpi.spring.gestion_recetas.persistance.domain.Receta;
import com.info.tpi.spring.gestion_recetas.presentation.dto.receta.RecetaCreateDto;
import com.info.tpi.spring.gestion_recetas.service.mappers.categoria.CategoriaMapper;
import com.info.tpi.spring.gestion_recetas.service.mappers.paso.PasoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(uses = {PasoMapper.class, CategoriaMapper.class})
public interface RecetaMapper {

    @Mapping(target = "categoria", ignore = true)
    Receta createDtoToEntity(RecetaCreateDto recetaCreateDto);

}