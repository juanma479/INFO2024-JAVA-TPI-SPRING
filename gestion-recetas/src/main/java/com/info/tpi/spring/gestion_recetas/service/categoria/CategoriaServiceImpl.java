package com.info.tpi.spring.gestion_recetas.service.categoria;

import com.info.tpi.spring.gestion_recetas.exceptions.BadRequestException;
import com.info.tpi.spring.gestion_recetas.exceptions.ResourceNotFoundException;
import com.info.tpi.spring.gestion_recetas.persistance.domain.Categoria;
import com.info.tpi.spring.gestion_recetas.persistance.domain.Receta;
import com.info.tpi.spring.gestion_recetas.persistance.repository.CategoriaRepository;
import com.info.tpi.spring.gestion_recetas.presentation.dto.categoria.CategoriaCreateDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.receta.RecetaByCategoriaDto;
import com.info.tpi.spring.gestion_recetas.service.mappers.categoria.CategoriaMapper;
import com.info.tpi.spring.gestion_recetas.service.mappers.receta.RecetaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private CategoriaRepository categoriaRepository;

    private CategoriaMapper categoriaMapper;
    private RecetaMapper recetaMapper;


    @Override
    public Categoria getOrCreateCategoria(UUID idCategoria, CategoriaCreateDto categoriaCreateDto) {


        if (idCategoria != null) {
            return categoriaRepository.findById(idCategoria).
                    orElseThrow(()-> new ResourceNotFoundException("Categoría no encontrada."));

        }

        Categoria newcategoria = categoriaMapper.createDtoToEntity(categoriaCreateDto);
        newcategoria.setId(UUID.randomUUID());
        newcategoria.setRecetas(new ArrayList<>());
        return categoriaRepository.save(newcategoria);
    }

    @Override
    public List<RecetaByCategoriaDto> getRecetasByCategoria(UUID idCategoria) {

        Optional<Categoria> categoria = categoriaRepository.findById(idCategoria);

        return categoria.map(value -> value.getRecetas().stream()
                .map(recetaMapper::entityToByCategoriaDto)
                .collect(Collectors.toList())).orElseGet(List::of);
    }
}