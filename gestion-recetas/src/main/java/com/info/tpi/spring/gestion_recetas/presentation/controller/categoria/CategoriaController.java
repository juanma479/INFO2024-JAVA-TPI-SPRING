package com.info.tpi.spring.gestion_recetas.presentation.controller.categoria;

import com.info.tpi.spring.gestion_recetas.presentation.dto.receta.RecetaByCategoriaDto;
import com.info.tpi.spring.gestion_recetas.service.categoria.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/categorias")
@AllArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;


    @GetMapping("/{idCategoria}")
    public ResponseEntity<?> getRecetasByCategoria(@PathVariable("idCategoria")UUID idCategoria) {

        List<RecetaByCategoriaDto> recetasFound = categoriaService.getRecetasByCategoria(idCategoria);

        if (!recetasFound.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(recetasFound);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}
