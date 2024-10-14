package com.info.tpi.spring.gestion_recetas.persistance.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @ToString.Exclude
    private Receta receta;

    private String descripcion;

    private int tiempoEstimado;

    private boolean esOpcional;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true )
    @JoinColumn(name = "paso_id")
    private List<Ingrediente> ingredientes;


}
