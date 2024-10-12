package com.info.tpi.spring.gestion_recetas.persistance.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "receta_id")
    private Receta receta;

    private String descripcion;

    private int tiempoEstimado;

    @ManyToMany
    @JoinTable(
            name = "paso_ingredientes", joinColumns = @JoinColumn(name = "paso_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
    private List<Ingrediente> ingredientes;

    private boolean esOpcional;
}
