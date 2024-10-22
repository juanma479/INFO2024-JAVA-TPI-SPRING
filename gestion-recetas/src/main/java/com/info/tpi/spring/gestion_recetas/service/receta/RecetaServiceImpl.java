package com.info.tpi.spring.gestion_recetas.service.receta;

import com.info.tpi.spring.gestion_recetas.exceptions.ResourceNotFoundException;
import com.info.tpi.spring.gestion_recetas.persistance.domain.Categoria;
import com.info.tpi.spring.gestion_recetas.persistance.domain.Receta;
import com.info.tpi.spring.gestion_recetas.persistance.repository.PasoRepository;
import com.info.tpi.spring.gestion_recetas.persistance.repository.RecetaRepository;
import com.info.tpi.spring.gestion_recetas.presentation.dto.categoria.CategoriaCreateDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.receta.RecetaCreateDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.receta.RecetaDto;
import com.info.tpi.spring.gestion_recetas.service.categoria.CategoriaService;
import com.info.tpi.spring.gestion_recetas.service.mappers.receta.RecetaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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


        Receta newReceta = recetaMapper.createDtoToEntity(recetaCreateDto);

        Categoria categoria;

        if(recetaCreateDto.idCategoria() != null) {
            categoria = categoriaService.getCategoria(recetaCreateDto.idCategoria());
        } else {

            categoria = categoriaService.createCategoria(categoriaCreateDto);
        }

        newReceta.setCategoria(categoria);

        Receta recetaSaved = recetaRepository.save(newReceta);


        recetaSaved.getPasos().forEach(paso -> {
            paso.setReceta(recetaSaved);
            pasoRepository.save(paso);
        });


        categoria.getRecetas().add(recetaSaved);

        return recetaMapper.entityToDto(recetaSaved);
    }

    @Override
    public RecetaDto getRecetaById(UUID idReceta) {

        return recetaMapper.entityToDto(this.getReceta(idReceta));
    }

    @Override
    public Receta getReceta(UUID idReceta) {
        return recetaRepository.findById(idReceta)
                .orElseThrow(() -> new ResourceNotFoundException("Receta no encontrada."));
    }

    @Override
    public boolean deleteReceta(UUID idReceta) {

        recetaRepository.deleteById(idReceta);
        return !recetaRepository.existsById(idReceta);
    }
}


