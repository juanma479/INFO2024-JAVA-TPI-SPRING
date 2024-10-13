package com.info.tpi.spring.gestion_recetas.persistance.domain;

import com.info.tpi.spring.gestion_recetas.persistance.domain.enums.DificultadEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    private String nombre;

    @Column(length = 5000)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private DificultadEnum dificultad;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;


    @OneToMany(mappedBy = "receta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paso> pasos;




}
