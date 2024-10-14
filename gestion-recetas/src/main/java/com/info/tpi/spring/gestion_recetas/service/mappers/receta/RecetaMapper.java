package com.info.tpi.spring.gestion_recetas.service.mappers.receta;

import com.info.tpi.spring.gestion_recetas.persistance.domain.Paso;
import com.info.tpi.spring.gestion_recetas.persistance.domain.Receta;
import com.info.tpi.spring.gestion_recetas.presentation.dto.receta.RecetaByCategoriaDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.receta.RecetaCreateDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.receta.RecetaDto;
import com.info.tpi.spring.gestion_recetas.service.mappers.categoria.CategoriaMapper;
import com.info.tpi.spring.gestion_recetas.service.mappers.paso.PasoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(uses = {PasoMapper.class, CategoriaMapper.class})
public interface RecetaMapper {

    @Mapping(target = "categoria", ignore = true)
    Receta createDtoToEntity(RecetaCreateDto recetaCreateDto);

    RecetaDto entityToDto(Receta receta);

    @Mapping(target = "tiempoTotal", expression = "java(calcularTiempoTotal(receta))")
    RecetaByCategoriaDto entityToByCategoriaDto( Receta receta);

    List<RecetaByCategoriaDto> entitiesToByCategoriaDtos( List<Receta> recetas);

    default int calcularTiempoTotal(Receta receta) {

        return receta.getPasos().stream().filter(paso -> !paso.isEsOpcional())
                .mapToInt(Paso::getTiempoEstimado).sum();
    }
}