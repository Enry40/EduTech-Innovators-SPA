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
public class Curso {
    @Id
    private int idCurso;
    private String nombreCurso;
    private String descripcionCurso;

    @ManyToOne
    private Administrador administrador;

    @ManyToMany(mappedBy = "cursosInscritos")
    private List<Estudiante> estudiantes;

    @OneToMany(mappedBy = "curso")
    private List<Evaluacion> evaluaciones;

}
