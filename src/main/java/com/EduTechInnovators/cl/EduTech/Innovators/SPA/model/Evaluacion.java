package com.EduTechInnovators.cl.EduTech.Innovators.SPA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evaluacion {
    @Id
    private int idEvaluacion;
    private String tituloEvaluacion;

    @ManyToOne
    private Profesor profesor;

    @ManyToOne
    private Curso curso;

    @ManyToMany(mappedBy = "evaluacionesTomadas")
    private List<Estudiante> estudiantes;
}
