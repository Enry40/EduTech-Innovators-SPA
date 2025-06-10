package com.EduTechInnovators.cl.EduTech.Innovators.SPA.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCurso;
    private String nombreCurso;
    private String descripcionCurso;
    private double evaluacionCurso;

    @ManyToMany(mappedBy = "cursos")
    private Set<Alumno> alumnos = new HashSet<>();

    @ManyToMany(mappedBy = "cursos")
    private Set<Profesor> profesores = new HashSet<>();

}
