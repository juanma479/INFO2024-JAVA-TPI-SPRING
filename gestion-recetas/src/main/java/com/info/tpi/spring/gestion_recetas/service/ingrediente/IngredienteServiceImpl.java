package com.info.tpi.spring.gestion_recetas.service.ingrediente;

import com.info.tpi.spring.gestion_recetas.exceptions.ResourceNotFoundException;
import com.info.tpi.spring.gestion_recetas.persistance.domain.Ingrediente;
import com.info.tpi.spring.gestion_recetas.persistance.domain.Paso;
import com.info.tpi.spring.gestion_recetas.persistance.repository.RecetaRepository;
import com.info.tpi.spring.gestion_recetas.presentation.dto.ingrediente.IngredienteDto;
import com.info.tpi.spring.gestion_recetas.service.mappers.ingrediente.IngredienteMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IngredienteServiceImpl implements IngredienteService {

    private RecetaRepository recetaRepository;

    private IngredienteMapper ingredienteMapper;


    @Override
    public List<IngredienteDto> getIngredientesOfReceta(UUID idReceta, Long idPaso) {

        var receta = recetaRepository.findById(idReceta)
                .orElseThrow(() -> new ResourceNotFoundException("Receta no encontrada."));

        if (idPaso == null) {
            List<IngredienteDto> ingredientes = new ArrayList<>();
            receta.getPasos().forEach(paso ->
                    paso.getIngredientes().forEach(ingrediente ->
                            ingredientes.add(ingredienteMapper.entityToDto(ingrediente))));

            return ingredientes;
        } else {

            var paso = receta.getPasos().stream().filter(p -> p.getId().equals(idPaso))
                    .findFirst().orElseThrow(() -> new ResourceNotFoundException("Paso no encontrado."));

            return paso.getIngredientes().stream()
                    .map(ingrediente -> ingredienteMapper.entityToDto(ingrediente))
                    .collect(Collectors.toList());

        }
    }


}