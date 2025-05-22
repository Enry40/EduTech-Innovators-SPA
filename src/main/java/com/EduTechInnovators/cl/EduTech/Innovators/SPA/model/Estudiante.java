package com.EduTechInnovators.cl.EduTech.Innovators.SPA.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {
    @Id
    private int idEstudiante;
    private String nombreEstudiante;
    private String cursosInscritos;

    @ManyToOne
    private Administrador administrador;

    @ManyToMany
    @JoinTable(
            name = "estudiante_cursos",
            joinColumns = @JoinColumn(name = "idEstudiante"),
            inverseJoinColumns = @JoinColumn(name = "idCurso"))
    private List<Curso> curso;

    @ManyToMany
    @JoinTable(
            name = "estudiante_evaluaciones",
            joinColumns = @JoinColumn(name = "idEstudiante"),
            inverseJoinColumns = @JoinColumn(name = "idEvaluacion"))
    private List<Evaluacion> evaluacionesTomadas;
}
