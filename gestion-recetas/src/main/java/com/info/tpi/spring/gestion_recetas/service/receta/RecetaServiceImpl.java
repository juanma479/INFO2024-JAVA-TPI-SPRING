package com.info.tpi.spring.gestion_recetas.service.receta;

import com.info.tpi.spring.gestion_recetas.exceptions.BadRequestException;
import com.info.tpi.spring.gestion_recetas.persistance.domain.Categoria;
import com.info.tpi.spring.gestion_recetas.persistance.domain.Receta;
import com.info.tpi.spring.gestion_recetas.persistance.repository.CategoriaRepository;
import com.info.tpi.spring.gestion_recetas.persistance.repository.PasoRepository;
import com.info.tpi.spring.gestion_recetas.persistance.repository.RecetaRepository;
import com.info.tpi.spring.gestion_recetas.presentation.dto.categoria.CategoriaCreateDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.receta.RecetaCreateDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.receta.RecetaDto;
import com.info.tpi.spring.gestion_recetas.service.categoria.CategoriaService;
import com.info.tpi.spring.gestion_recetas.service.mappers.receta.RecetaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RecetaServiceImpl implements RecetaService {

    private PasoRepository pasoRepository;
    private RecetaRepository recetaRepository;

    private RecetaMapper recetaMapper;

    private CategoriaService categoriaService;

    @Override
    public RecetaDto createReceta(RecetaCreateDto recetaCreateDto, CategoriaCreateDto categoriaCreateDto) {
        //Creamos una nueva receta mediante el mapper
        Receta newReceta = recetaMapper.createDtoToEntity(recetaCreateDto);

        //Buscamos o creamos una categoria
        Categoria categoria = categoriaService.getOrCreateCategoria(recetaCreateDto.idCategoria(),
                categoriaCreateDto);

        //Seteamos atributo id y categoria de la receta
        newReceta.setId(UUID.randomUUID());
        newReceta.setCategoria(categoria);

        //Persistimos la receta
        Receta recetaSaved = recetaRepository.save(newReceta);

        //Asignamos el atributo receta para cada objeto paso dentro de la receta y lo persistimos
        recetaSaved.getPasos().forEach(paso -> {
            paso.setReceta(recetaSaved);
            pasoRepository.save(paso);
        });

        //Agregamos la receta creada a la lista de la categoría a la que pertenece
        categoria.getRecetas().add(recetaSaved);

        //Retornamos la receta creada como Dto usando nuevamente un mappper
        return recetaMapper.entityToDto(recetaSaved);
    }

    @Override
    public RecetaDto getRecetaById(UUID idReceta) {

        return recetaMapper.entityToDto(recetaRepository.getReferenceById(idReceta));
    }

    @Override
    public boolean deleteReceta(UUID idReceta) {

        recetaRepository.deleteById(idReceta);
        if(!recetaRepository.existsById(idReceta)){
            return true;
        };
        return false;
    }
}


