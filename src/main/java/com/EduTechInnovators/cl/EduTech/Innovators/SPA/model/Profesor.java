package com.EduTechInnovators.cl.EduTech.Innovators.SPA.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {

    @Id
    private int idProfesor;
    private String nombreProfesor;
    private String asignatura;

    @ManyToOne
    private Administrador administrador;

    @OneToMany(mappedBy = "profesor")
    private List<Evaluacion> evaluaciones;

}
