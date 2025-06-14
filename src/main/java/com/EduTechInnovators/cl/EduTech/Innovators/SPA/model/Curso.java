package com.EduTechInnovators.cl.EduTech.Innovators.SPA.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cursos")
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

    public List<String> addAlumnoCurso(Alumno alumno) {
        List<String> mensajes = new ArrayList<>();
        if (alumnos.contains(alumno)) {
            mensajes.add("El alumno ya se encuentra registrado");
        } else {
            alumnos.add(alumno);
            mensajes.add("Alumno registrado correctamente");
        }
        return mensajes;
    }

    public List<String> addProfesorCurso(Profesor profesor) {
        List<String> mensajes = new ArrayList<>();
        if (profesores.contains(profesor)) {
            mensajes.add("El profesor ya se encuentra registrado");
        } else {
            profesores.add(profesor);
            mensajes.add("Profesor registrado correctamente");
        }
        return mensajes;
    }
}

