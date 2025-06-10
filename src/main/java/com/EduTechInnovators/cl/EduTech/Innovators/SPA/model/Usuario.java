package com.EduTechInnovators.cl.EduTech.Innovators.SPA.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "usuarios")
@Inheritance (strategy = InheritanceType.JOINED)
public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String telefonoUsuario;
    private String direccionUsuario;
    private String tipoUsuario;
}
