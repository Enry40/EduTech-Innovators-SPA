package com.EduTechInnovators.cl.EduTech.Innovators.SPA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "administradores")
@EqualsAndHashCode(callSuper = true)
public class Administrador extends Usuario{
    private String correoAdmin;
}
