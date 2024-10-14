package com.info.tpi.spring.gestion_recetas.service.categoria;

import com.info.tpi.spring.gestion_recetas.exceptions.BadRequestException;
import com.info.tpi.spring.gestion_recetas.exceptions.ResourceNotFoundException;
import com.info.tpi.spring.gestion_recetas.persistance.domain.Categoria;
import com.info.tpi.spring.gestion_recetas.persistance.repository.CategoriaRepository;
import com.info.tpi.spring.gestion_recetas.presentation.dto.categoria.CategoriaCreateDto;
import com.info.tpi.spring.gestion_recetas.service.mappers.categoria.CategoriaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private CategoriaRepository categoriaRepository;

    private CategoriaMapper categoriaMapper;


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
}
