package com.EduTechInnovators.cl.EduTech.Innovators.SPA.controller;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Alumno;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.AlumnoServiceImpl;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    private final AlumnoServiceImpl alumnoService;

    private final CursoService cursoService;

    @Autowired
    public AlumnoController(AlumnoServiceImpl alumnoService, CursoService cursoService) {
        this.alumnoService = alumnoService;
        this.cursoService = cursoService;
    }

    @PutMapping("/{alumnoId}")
    public String updateAlumno(@PathVariable int alumnoId, @RequestBody Alumno alumno) {
        return alumnoService.updateAlumno(alumnoId, alumno);
    }

    @GetMapping("/cursos")
    public String getAllCursos() {
        return cursoService.getAllCursos();
    }

}
