package com.EduTechInnovators.cl.EduTech.Innovators.SPA.controller;


import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;


}
