package com.info.tpi.spring.gestion_recetas.service.categoria;

import com.info.tpi.spring.gestion_recetas.exceptions.DuplicateDataException;
import com.info.tpi.spring.gestion_recetas.exceptions.ResourceNotFoundException;
import com.info.tpi.spring.gestion_recetas.persistance.domain.Categoria;
import com.info.tpi.spring.gestion_recetas.persistance.repository.CategoriaRepository;
import com.info.tpi.spring.gestion_recetas.presentation.dto.categoria.CategoriaCreateDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.receta.RecetaByCategoriaDto;
import com.info.tpi.spring.gestion_recetas.service.mappers.categoria.CategoriaMapper;
import com.info.tpi.spring.gestion_recetas.service.mappers.receta.RecetaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private CategoriaRepository categoriaRepository;

    private CategoriaMapper categoriaMapper;
    private RecetaMapper recetaMapper;


    @Override
    public Categoria getCategoria(UUID idCategoria) {

        return categoriaRepository.findById(idCategoria).
                orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada."));

    }


    @Override
    public Categoria createCategoria(CategoriaCreateDto categoriaCreateDto) {

        if (categoriaRepository.existsByNombre(categoriaCreateDto.nombre())) {
            throw new DuplicateDataException("Ya existe una categoría con ese nombre");
        }
        Categoria newcategoria = categoriaMapper.createDtoToEntity(categoriaCreateDto);
        newcategoria.setRecetas(new ArrayList<>());
        return categoriaRepository.save(newcategoria);
    }


    @Override
    public List<RecetaByCategoriaDto> getRecetasByCategoria(UUID idCategoria) {

            Categoria categoria = this.getCategoria(idCategoria);

                    return categoria.getRecetas().stream().map(recetaMapper::entityToByCategoriaDto)
                            .collect(Collectors.toList());
    }
}
