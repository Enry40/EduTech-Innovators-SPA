package com.EduTechInnovators.cl.EduTech.Innovators.SPA.controller;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Administrador;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Curso;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Estudiante;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Profesor;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/administrador")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @PostMapping
    public String addAdministrador(@RequestBody Administrador admin) {
        return administradorService.addAdministrador(admin);
    }

    @GetMapping("/{id}")
    public String getAdministradorById(@PathVariable int id) {
        return administradorService.getAdministradorById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteAdministrador(@PathVariable int id) {
        return administradorService.deleteAdministrador(id);
    }


    @PostMapping("/estudiante")
    public String addEstudiante(@RequestBody Estudiante estudiante) {
        return administradorService.addEstudiante(estudiante);
    }

    @GetMapping("/estudiante/{id}")
    public String getEstudianteById(@PathVariable int id) {
        return administradorService.getEstudianteById(id);
    }

    @PutMapping("/estudiante/{id}")
    public String updateEstudiante(@PathVariable int id, @RequestBody Estudiante estudiante) {
        return administradorService.updateEstudiante(id, estudiante);
    }

    @DeleteMapping("/estudiante/{id}")
    public String deleteEstudiante(@PathVariable int id) {
        return administradorService.deleteEstudiante(id);
    }

    @GetMapping("/estudiante/{id}")
    public String getAllEstudiantes() {
        return administradorService.getAllEstudiantes();
    }


    @PostMapping("/profesor")
    public String addProfesor(@RequestBody Profesor profesor) {
        return administradorService.addProfesor(profesor);
    }

    @GetMapping("/profesor/{id}")
    public String getProfesorById(@PathVariable int id) {
        return administradorService.getProfesorById(id);
    }

    @PutMapping("/profesor/{id}")
    public String updateProfesor(@PathVariable int id, @RequestBody Profesor profesor) {
        return administradorService.updateProfesor(id, profesor);
    }

    @DeleteMapping("/profesor/{id}")
    public String deleteProfesor(@PathVariable int id) {
        return administradorService.deleteProfesor(id);
    }
    @GetMapping
    public String getAllProfesores() {
        return administradorService.getAllProfesores();
    }

    @PostMapping("/curso")
    public String addCurso(@RequestBody Curso curso) {
        return administradorService.addCurso(curso);
    }

    @GetMapping("/curso/{id}")
    public String getCursoById(@PathVariable int id) {
        return administradorService.getCursoById(id);
    }

    @PutMapping("/curso/{id}")
    public String updateCurso(@PathVariable int id, @RequestBody Curso curso) {
        return administradorService.updateCurso(id, curso);
    }

    @DeleteMapping("/curso/{id}")
    public String deleteCurso(@PathVariable int id) {
        return administradorService.deleteCurso(id);
    }

    @GetMapping
    public String getAllCursos() {
        return administradorService.getAllCursos();
    }

}
