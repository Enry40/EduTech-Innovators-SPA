package com.EduTechInnovators.cl.EduTech.Innovators.SPA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrador {
    @Id
    private int idAdmin;

    @OneToMany(mappedBy = "administrador")
    private List<Estudiante> estudiantes;

    @OneToMany(mappedBy = "administrador")
    private List<Profesor> profesores;

    @OneToMany(mappedBy = "administrador")
    private List<Curso> cursos;

}
