package com.EduTechInnovators.cl.EduTech.Innovators.SPA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    @Id
    private int idUsuario;
    private String nombreUsuario;
    private String contrasenia;
    private String correo;
    private String tipoUsuario;
    @ManyToOne
    private Administrador administrador;

}
