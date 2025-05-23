package com.EduTechInnovators.cl.EduTech.Innovators.SPA.controller;


import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorController {

    @Autowired
    private ProfesorRepository profesorRepository;

}
