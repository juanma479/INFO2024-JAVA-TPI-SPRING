package com.info.tpi.spring.gestion_recetas.presentation.controller.receta;

import com.info.tpi.spring.gestion_recetas.presentation.dto.ingrediente.IngredienteDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.paso.PasoChangeDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.paso.PasoUpdatedDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.receta.RecetaDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.receta.RecetaRequestDto;
import com.info.tpi.spring.gestion_recetas.service.ingrediente.IngredienteService;
import com.info.tpi.spring.gestion_recetas.service.paso.PasoService;
import com.info.tpi.spring.gestion_recetas.service.receta.RecetaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/recetas")
@AllArgsConstructor

public class RecetaController {

    private final IngredienteService ingredienteService;
    private final PasoService pasoService;
    private final RecetaService recetaService;

    @Operation(
            summary = "API REST para crear recetas",
            description = "Permite crear recetas."
    )
    @ApiResponses(
            @ApiResponse(
                    responseCode = "201",
                    description = "Receta creada",
                    content = @Content(schema = @Schema(implementation = RecetaDto.class))
            )

    )
    @PostMapping()
    public ResponseEntity<RecetaDto> createReceta(@Valid@RequestBody RecetaRequestDto requestDto){

        RecetaDto recetaCreated = recetaService.createReceta(requestDto.recetaCreateDto(),
                requestDto.categoriaCreateDto());

        return new ResponseEntity<>(recetaCreated, HttpStatus.CREATED);
    }

    @Operation(
            summary = "API REST para buscar recetas por Id.",
            description = "Permite obtener una receta mediante su Id."
    )
    @ApiResponses(
            @ApiResponse(
                    responseCode = "200",
                    description = "Receta Encontrada",
                    content = @Content(schema = @Schema(implementation = RecetaDto.class))
            )

    )
    @GetMapping("/{idReceta}")
    public ResponseEntity<RecetaDto> getRecetaById(@Valid@PathVariable("idReceta")UUID idReceta) {

        RecetaDto recetaFound = recetaService.getRecetaById(idReceta);

        return new ResponseEntity<>(recetaFound,HttpStatus.OK);
    }

    @Operation(
            summary = "API REST para borrar una receta por Id.",
            description = "Permite borrar recetas de la bd mediante su Id."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "No hay contenido por mostrar."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No se encontró la receta."
            )}

    )
    @DeleteMapping("{idReceta}")
    public ResponseEntity<?> deleteReceta(@Valid@PathVariable("idReceta") UUID idReceta) {

        boolean isRecetaDeleted = recetaService.deleteReceta(idReceta);

        if(isRecetaDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Receta no encontrada.");
        }
    }


    @Operation(
            summary = "API REST para actualizar información de los pasos de una receta",
            description = "Permite modificar la información de unos pasos de una receta mediante el Id de la receta."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "404",
                    description = "No se pudieron actualizar los pasos."
            ),
            @ApiResponse(
                    responseCode = "200",
                    description = "Pasos actualizados.",
                    content = @Content(schema = @Schema(implementation = PasoUpdatedDto.class))
            )}
    )
    @PutMapping("/{idReceta}/pasos")
    public ResponseEntity<?> updatePasos(@Valid@PathVariable("idReceta") UUID idReceta,
                                         @Valid@RequestBody List<PasoChangeDto> pasoChangeDtos) {

        List<PasoUpdatedDto> pasosUpdated = pasoService.updatePasosOfList(idReceta, pasoChangeDtos);

        if (pasosUpdated.isEmpty()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error al actualizar pasos de receta.");
        }
        return ResponseEntity.ok(pasosUpdated);
    }

    @Operation(
            summary = "API REST para buscar los ingredientes de uno o todos los pasos de una receta.",
            description = "Permite obtener los ingredientes que necesita uno o todos los pasos de una receta " +
                    "dado el Id de la receta " +
                    "y opcionalmente el id del paso"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "404",
                    description = "No se encontraron los ingredientes."
            ),
            @ApiResponse(
                    responseCode = "200",
                    description = "Igredientes encontrados",
                    content = @Content(schema = @Schema(implementation = IngredienteDto.class))
            )}

    )
    @GetMapping("/{idReceta}/ingredientes")
    public ResponseEntity<?> getIngredientesByReceta(@Valid@PathVariable("idReceta") UUID idReceta,
                                                     @Valid@RequestParam(value = "idPaso", required = false) Long idPaso) {

        List<IngredienteDto> ingredientesFound = ingredienteService.getIngredientesOfReceta(idReceta, idPaso);

        if (ingredientesFound.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron ingredientes.");
        }
        return ResponseEntity.ok(ingredientesFound);
    }

}
