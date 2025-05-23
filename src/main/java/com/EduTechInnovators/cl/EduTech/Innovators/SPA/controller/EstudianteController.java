package com.EduTechInnovators.cl.EduTech.Innovators.SPA.controller;


import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepository;





}
