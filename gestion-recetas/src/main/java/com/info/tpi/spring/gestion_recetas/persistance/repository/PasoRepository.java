package com.info.tpi.spring.gestion_recetas.persistance.repository;

import com.info.tpi.spring.gestion_recetas.persistance.domain.Paso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasoRepository extends JpaRepository<Paso, Long> {
}
