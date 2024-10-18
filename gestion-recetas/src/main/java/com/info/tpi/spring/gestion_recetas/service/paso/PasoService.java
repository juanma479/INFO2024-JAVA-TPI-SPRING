package com.info.tpi.spring.gestion_recetas.service.paso;

import com.info.tpi.spring.gestion_recetas.persistance.domain.Ingrediente;
import com.info.tpi.spring.gestion_recetas.presentation.dto.paso.PasoChangeDto;
import com.info.tpi.spring.gestion_recetas.presentation.dto.paso.PasoUpdatedDto;

import java.util.List;
import java.util.UUID;

public interface PasoService {

    List<PasoUpdatedDto> updatePasosOfList(UUID idReceta, List<PasoChangeDto> pasoChangeDtos);

}
