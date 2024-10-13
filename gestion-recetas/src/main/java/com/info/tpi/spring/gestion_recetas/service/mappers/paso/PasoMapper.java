package com.info.tpi.spring.gestion_recetas.service.mappers.paso;

import com.info.tpi.spring.gestion_recetas.persistance.domain.Paso;
import com.info.tpi.spring.gestion_recetas.presentation.dto.paso.PasoCreateDto;
import com.info.tpi.spring.gestion_recetas.service.mappers.ingrediente.IngredienteMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {IngredienteMapper.class})
public interface PasoMapper {

    Paso createDtoToEntity(PasoCreateDto pasoCreateDto);

    List<Paso> createDtosToEntities(List<PasoCreateDto> pasoCreateDtos);
}
