package com.info.tpi.spring.gestion_recetas.persistance.repository;

import com.info.tpi.spring.gestion_recetas.persistance.domain.Receta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecetaRepository extends JpaRepository<Receta, UUID> {
}
