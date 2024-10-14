package com.info.tpi.spring.gestion_recetas.service.mappers.ingrediente;

import com.info.tpi.spring.gestion_recetas.persistance.domain.Ingrediente;
import com.info.tpi.spring.gestion_recetas.presentation.dto.ingrediente.IngredienteCreateDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.ingrediente.IngredienteDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface IngredienteMapper {

    Ingrediente createDtoToEntity(IngredienteCreateDto ingredienteCreateDto);

    List<Ingrediente> createDtosToEntities(List<IngredienteCreateDto> ingredienteCreateDtos);

    IngredienteDto entityToDto(Ingrediente ingrediente);

    List<IngredienteDto> entitiesToDtos(List<Ingrediente> ingredientes);
}
