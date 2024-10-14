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

    private CategoriaRepository categoriaRepository;
    private PasoRepository pasoRepository;
    private RecetaRepository recetaRepository;

    private RecetaMapper recetaMapper;

    private CategoriaService categoriaService;

    @Override
    public RecetaDto createReceta(RecetaCreateDto recetaCreateDto, CategoriaCreateDto categoriaCreateDto) {
        return null;
    }
}


