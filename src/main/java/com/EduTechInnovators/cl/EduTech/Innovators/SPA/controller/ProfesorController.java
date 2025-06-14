package com.EduTechInnovators.cl.EduTech.Innovators.SPA.controller;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Curso;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Profesor;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.CursoService;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorServiceImpl profesorService;

    private final CursoService cursoService;
    @Autowired
    public ProfesorController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PutMapping("/{profesorId}")
    public String updateProfesorPro(@PathVariable int profesorId, @RequestBody Profesor profe) {
        return profesorService.updateProfesor(profesorId, profe);
    }

    @GetMapping("/cursos")
    public String getAllCursos() {
        return cursoService.getAllCursos();
    }

    @PutMapping("/cursos/{cursoId}")
    public String updateCursoProfe(@PathVariable int cursoId, @RequestBody Curso curso) {
        return cursoService.updateCursoProfe(cursoId, curso);
    }

}
