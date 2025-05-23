package com.EduTechInnovators.cl.EduTech.Innovators.SPA.controller;


import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/evaluacion")
public class EvaluacionController {

    @Autowired
    EvaluacionService evaluacionService;


}
