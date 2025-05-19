package com.EduTechInnovators.cl.EduTech.Innovators.SPA.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
