package com.info.tpi.spring.gestion_recetas.persistance.repository;

import com.info.tpi.spring.gestion_recetas.persistance.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {

    boolean existsByNombre(String nombre);

//    @Query("SELECT c FROM Categoria c JOIN FETCH c.recetas WHERE c.id = :id")
//    Optional<Categoria> findByIdWithRecetas(@Param("id") UUID id);

}
