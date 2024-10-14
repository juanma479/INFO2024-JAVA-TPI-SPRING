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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
