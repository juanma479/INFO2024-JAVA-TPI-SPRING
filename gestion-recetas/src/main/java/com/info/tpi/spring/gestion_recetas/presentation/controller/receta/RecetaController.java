package com.info.tpi.spring.gestion_recetas.presentation.controller.receta;

import com.info.tpi.spring.gestion_recetas.persistance.domain.Receta;
import com.info.tpi.spring.gestion_recetas.presentation.dto.receta.RecetaDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.receta.RecetaRequestDto;
import com.info.tpi.spring.gestion_recetas.service.receta.RecetaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/receta")
@AllArgsConstructor
@Slf4j
public class RecetaController {

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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

}
