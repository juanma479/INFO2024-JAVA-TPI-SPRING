package com.info.tpi.spring.gestion_recetas.presentation.controller.receta;

import com.info.tpi.spring.gestion_recetas.presentation.dto.ingrediente.IngredienteDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.paso.PasoChangeDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.paso.PasoUpdatedDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.receta.RecetaDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.receta.RecetaRequestDto;
import com.info.tpi.spring.gestion_recetas.service.ingrediente.IngredienteService;
import com.info.tpi.spring.gestion_recetas.service.paso.PasoService;
import com.info.tpi.spring.gestion_recetas.service.receta.RecetaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/recetas")
@AllArgsConstructor
@Slf4j
public class RecetaController {

    private final IngredienteService ingredienteService;
    private final PasoService pasoService;
    private final RecetaService recetaService;

    @PostMapping()
    public ResponseEntity<RecetaDto> createReceta(@Valid@RequestBody RecetaRequestDto requestDto){
        log.info("Solicitud de creación recibida:{}",requestDto.recetaCreateDto().nombre());

        RecetaDto recetaCreated = recetaService.createReceta(requestDto.recetaCreateDto(),
                requestDto.categoriaCreateDto());

        log.info("Receta creada exitosamente con ID: {}",recetaCreated.id());

        return new ResponseEntity<>(recetaCreated, HttpStatus.CREATED);
    }


    @GetMapping("/{idReceta}")
    public ResponseEntity<RecetaDto> getRecetaById(@PathVariable("idReceta")UUID idReceta) {

        RecetaDto recetaFound = recetaService.getRecetaById(idReceta);

        return new ResponseEntity<>(recetaFound,HttpStatus.OK);
    }

    @DeleteMapping("{idReceta}")
    public ResponseEntity<?> deleteReceta(@PathVariable("idReceta") UUID idReceta) {

        boolean isRecetaDeleted = recetaService.deleteReceta(idReceta);

        if(isRecetaDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Receta no encontrada.");
        }
    }


    @PutMapping("/{idReceta}/pasos")
    public ResponseEntity<?> updatePasos(@PathVariable("idReceta") UUID idReceta,
                                         @RequestBody List<PasoChangeDto> pasoChangeDtos) {

        List<PasoUpdatedDto> pasosUpdated = pasoService.updatePasosOfList(idReceta, pasoChangeDtos);

        if (pasosUpdated.isEmpty()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error al actualizar pasos de receta.");
        }
        return ResponseEntity.ok(pasosUpdated);
    }

    @GetMapping("/{idReceta}/ingredientes")
    public ResponseEntity<?> getIngredientesByReceta(@PathVariable("idReceta") UUID idReceta,
                                                     @RequestParam(value = "idPaso", required = false) Long idPaso) {

        List<IngredienteDto> ingredientesFound = ingredienteService.getIngredientesOfReceta(idReceta, idPaso);

        if (ingredientesFound.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron ingredientes.");
        }
        return ResponseEntity.ok(ingredientesFound);
    }

}
