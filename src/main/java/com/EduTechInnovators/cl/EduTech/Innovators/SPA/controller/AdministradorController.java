package com.EduTechInnovators.cl.EduTech.Innovators.SPA.controller;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Administrador;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Alumno;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Curso;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Profesor;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.AdministradorServiceImpl;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.AlumnoServiceImpl;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.CursoService;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorServiceImpl administradorService;

    @Autowired
    private AlumnoServiceImpl alumnoService;

    @Autowired
    private ProfesorServiceImpl profesorService;

    @Autowired
    private CursoService cursoService;

    // Administrador
    @PostMapping
    public String addAdmin(@RequestBody Administrador admin) {
        admin.setTipoUsuario("Administrador");
        return administradorService.addAdmin(admin);
    }

    @GetMapping
    public String getAllAdmin() {
        return administradorService.getAllAdmin();
    }

    @GetMapping("/{id}")
    public String getAdminById(@PathVariable int id) {
        return administradorService.getAdminById(id);
    }

    @PutMapping("/{id}")
    public String updateAdmin(@PathVariable int id, @RequestBody Administrador admin) {
        return administradorService.updateAdmin(id, admin);
    }

    @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable int id) {
        return administradorService.deleteAdmin(id);
    }

    // Alumno
    @PostMapping("/alumnos")
    public String addAlumno(@RequestBody Alumno alu) {
        alu.setTipoUsuario("Alumno");
        return alumnoService.addAlumno(alu);
    }

    @GetMapping("/alumnos")
    public String getAllAlumnos() {
        return alumnoService.getAllAlumnos();
    }

    @GetMapping("/alumnos/{alumnoId}")
    public String getAlumnoById(@PathVariable int alumnoId) {
        return alumnoService.getAlumnoById(alumnoId);
    }

    @PutMapping("/alumnos/{alumnoId}")
    public String updateAlumno(@PathVariable int alumnoId, @RequestBody Alumno alumno) {
        return alumnoService.updateAlumno(alumnoId, alumno);
    }

    @DeleteMapping("/alumnos/{alumnoId}")
    public String deleteAlumno(@PathVariable int alumnoId) {
        return alumnoService.deleteAlumno(alumnoId);
    }

    // Profesor
    @PostMapping("/profesores")
    public String addProfesor(@RequestBody Profesor prof) {
        prof.setTipoUsuario("Profesor");
        return profesorService.addProfesor(prof);
    }

    @GetMapping("/profesores/{profesorId}")
    public String getProfesorById(@PathVariable int profesorId) {
        return profesorService.getProfesoresById(profesorId);
    }

    @GetMapping("/profesores")
    public String getAllProfesores() {
        return profesorService.getAllProfesores();
    }

    @PutMapping("/profesores/{profesorId}")
    public String updateProfesor(@PathVariable int profesorId, @RequestBody Profesor prof) {
        return profesorService.updateProfesor(profesorId, prof);
    }

    @DeleteMapping("/profesores/{profesorId}")
    public String deleteProfesor(@PathVariable int profesorId) {
        return profesorService.deleteProfesor(profesorId);
    }

    // Curso
    @PostMapping("/cursos")
    public String addCurso(@RequestBody Curso curso) {
        return cursoService.addCurso(curso);
    }

    @PostMapping("/cursos/{cursoId}/alumnos/{alumnoId}")
    public List<String> addAlumnoCurso(@PathVariable("cursoId") int idCurso, @PathVariable("alumnoId") int idAlumno) {
        return cursoService.addAlumnoCurso(idCurso, idAlumno);
    }

    @PostMapping("/cursos/{cursoId}/profesores/{profesorId}")
    public List<String> addProfesorCurso(@PathVariable("cursoId") int idCurso, @PathVariable("profesorId") int idProfesor) {
        return cursoService.addProfesorCurso(idCurso, idProfesor);
    }

    @GetMapping("/cursos")
    public String getAllCursos() {
        return cursoService.getAllCursos();
    }

    @DeleteMapping("/cursos/{cursoId}")
    public String deleteCurso(@PathVariable int cursoId) {
        return cursoService.deleteCurso(cursoId);
    }

    @PutMapping("/cursos/{cursoId}")
    public String updateCursoAdmin(@PathVariable int cursoId, @RequestBody Curso curso) {
        return cursoService.updateCursoAdmin(cursoId, curso);
    }

    @GetMapping("/cursos/{cursoId}")
    public String getCursoById(@PathVariable int cursoId) {
        return cursoService.getCursoById(cursoId);
    }

}
