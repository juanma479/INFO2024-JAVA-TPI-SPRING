package com.info.tpi.spring.gestion_recetas.persistance.repository;

import com.info.tpi.spring.gestion_recetas.persistance.domain.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
}
