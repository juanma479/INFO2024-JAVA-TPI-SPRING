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
    private UUID id;

    private String nombre;

    @OneToMany(mappedBy = "receta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paso> pasos;

    @Enumerated(EnumType.STRING)
    private DificultadEnum dificultad;

    @Column(length = 5000)
    private String descripcion;

    @ManyToOne
    @Column(name = "categoria_id")
    private Categoria categoria;

}
