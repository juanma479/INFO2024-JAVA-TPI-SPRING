package com.info.tpi.spring.gestion_recetas.service.paso;

import com.info.tpi.spring.gestion_recetas.exceptions.ResourceNotFoundException;
import com.info.tpi.spring.gestion_recetas.persistance.domain.Ingrediente;
import com.info.tpi.spring.gestion_recetas.persistance.repository.RecetaRepository;
import com.info.tpi.spring.gestion_recetas.presentation.dto.paso.PasoChangeDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.paso.PasoUpdatedDto;
import com.info.tpi.spring.gestion_recetas.service.mappers.ingrediente.IngredienteMapper;
import com.info.tpi.spring.gestion_recetas.service.mappers.paso.PasoMapper;
import com.info.tpi.spring.gestion_recetas.service.receta.RecetaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PasoServiceImpl implements PasoService {

    private RecetaRepository recetaRepository;

    private IngredienteMapper ingredienteMapper;
    private PasoMapper pasoMapper;

    private RecetaService recetaService;

    @Override
    public List<PasoUpdatedDto> updatePasosOfList(UUID idReceta, List<PasoChangeDto> pasoChangeDtos) {

            var receta = recetaService.getReceta(idReceta);


            var pasosActuales = receta.getPasos();

            if (pasosActuales.size() != pasoChangeDtos.size()) {
                throw new IllegalArgumentException("El numero de pasos a actualizar no coincide.");
            }

            for (int i = 0; i < pasosActuales.size(); i++) {
                var pasoActual = pasosActuales.get(i);
                var pasoChange = pasoChangeDtos.get(i);

                pasoActual.setDescripcion(pasoChange.descripcion());
                pasoActual.setTiempoEstimado(pasoChange.tiempoEstimado());
                pasoActual.setEsOpcional(pasoChange.esOpcional());

                var ingredientesActuales = pasoActual.getIngredientes();
                var ingredientesChange = pasoChange.ingredientes();

                ingredientesActuales.clear();
                ingredientesChange.forEach(ingredienteCreateDto -> {
                    Ingrediente ingrediente = ingredienteMapper.createDtoToEntity(ingredienteCreateDto);
                    ingredientesActuales.add(ingrediente);
                });
            }

            recetaRepository.save(receta);

            return pasosActuales.stream().map(paso -> pasoMapper.entityToUpdatedDto(paso))
                    .collect(Collectors.toList());
        }

}
