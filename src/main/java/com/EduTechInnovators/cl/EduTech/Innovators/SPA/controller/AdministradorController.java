package com.EduTechInnovators.cl.EduTech.Innovators.SPA.controller;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.assembler.AdministradorModelAssembler;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Administrador;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Alumno;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Curso;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Profesor;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.AdministradorServiceImpl;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.AlumnoServiceImpl;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.CursoService;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.ProfesorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administradores")
@Tag(name = "Controlador Usuarios", description = "Servicio gestion de usuarios EduTech")
public class AdministradorController {

    @Autowired
    private AdministradorServiceImpl administradorService;

    @Autowired
    private AlumnoServiceImpl alumnoService;

    @Autowired
    private ProfesorServiceImpl profesorService;

    @Autowired
    private CursoService cursoService;

    @Autowired
    AdministradorModelAssembler assembler;

    // ADMINISTRADOR
    @PostMapping
    @Operation(summary = "Agregar Administrador", description = "Permite registrar un administrador en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Administrador creado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Administrador.class))),
            @ApiResponse(responseCode = "204", description = "No hay contenido en la solicitud")
    })
    public ResponseEntity<String> addAdmin(@RequestBody Administrador administrador) {
        String response = administradorService.addAdmin(administrador);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Obtener Administradores", description = "Obtiene la lista completa de administradores registrados en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna lista completa de administradores"),
            @ApiResponse(responseCode = "404", description = "No se encuentran datos")
    })
    public ResponseEntity<String> getAllAdmin() {
        String response = administradorService.getAllAdmin();
        if (response.equals("No se encontraron administradores")) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Administrador por ID", description = "Obtiene un administrador según el ID registrado en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna Administrador"),
            @ApiResponse(responseCode = "404", description = "No se encuentran datos")
    })
    @Parameter(description = "El ID del administrador", example = "123")
    public ResponseEntity<String> getAdminById(@PathVariable int id) {
        String response = administradorService.getAdminById(id);
        if (response.contains("Administrador no encontrado")) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Administrador", description = "Permite actualizar los datos de un administrador según su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Administrador modificado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Administrador.class))),
            @ApiResponse(responseCode = "204", description = "No hay contenido en la solicitud")
    })
    @Parameter(description = "El ID del administrador", example = "123")
    public ResponseEntity<String> updateAdmin(@PathVariable int id, @RequestBody Administrador administrador) {
        String response = administradorService.updateAdmin(id, administrador);
        if (response.contains("Administrador no encontrado")) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Administrador por ID", description = "Elimina un administrador según el ID registrado en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Administrador eliminado"),
            @ApiResponse(responseCode = "404", description = "No se encuentran datos")
    })
    @Parameter(description = "El ID del administrador", example = "123")
    public ResponseEntity<String> deleteAdmin(@PathVariable int id) {
        String response = administradorService.deleteAdmin(id);
        if (response.contains("Administrador no encontrado")) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
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
