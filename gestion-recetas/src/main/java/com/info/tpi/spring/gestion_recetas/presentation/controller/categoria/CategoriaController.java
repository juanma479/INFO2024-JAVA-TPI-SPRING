package com.info.tpi.spring.gestion_recetas.presentation.controller.categoria;

import com.info.tpi.spring.gestion_recetas.presentation.dto.receta.RecetaByCategoriaDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.receta.RecetaDto;
import com.info.tpi.spring.gestion_recetas.service.categoria.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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


    @Operation(
            summary = "API REST para buscar recetas dada una categoría específica.",
            description = "Permite obtener la o las recetas que se vinculan a cierta categoría."
    )
    @ApiResponses(
            @ApiResponse(
                    responseCode = "200",
                    description = "Receta/s Encontrada/s",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = RecetaByCategoriaDto.class)))
            )

    )
    @GetMapping("/{idCategoria}")
    public ResponseEntity<?> getRecetasByCategoria(@PathVariable("idCategoria")UUID idCategoria) {

        List<RecetaByCategoriaDto> recetasFound = categoriaService.getRecetasByCategoria(idCategoria);

            return ResponseEntity.status(HttpStatus.OK).body(recetasFound);

    }
}
