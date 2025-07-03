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

    // ALUMNO
    @PostMapping("/alumnos")
    @Operation(summary = "Agregar Alumno", description = "Permite registrar un alumno en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Alumno creado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Alumno.class))),
            @ApiResponse(responseCode = "204", description = "No hay contenido en la solicitud")
    })
    public ResponseEntity <String> addAlumno(@RequestBody Alumno alu) {
        String response = alumnoService.addAlumno(alu);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/alumnos")
    @Operation(summary = "Obtener Alumnos", description = "Obtiene la lista completa de alumnos registrados en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna lista completa de alumnos"),
            @ApiResponse(responseCode = "404", description = "No se encuentran datos")
    })
    public ResponseEntity<String> getAllAlumnos() {
        String response = alumnoService.getAllAlumnos();
        if (response.equals("No se encontraron alumnos")) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }  else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/alumnos/{alumnoId}")
    @Operation(summary = "Buscar Alumno por ID", description = "Obtiene un alumno según el ID registrado en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna Alumno"),
            @ApiResponse(responseCode = "404", description = "No se encuentran datos")
    })
    @Parameter(description = "El ID del alumno", example = "123")
    public ResponseEntity<String> getAlumnoById(@PathVariable int alumnoId) {
        String response = alumnoService.getAlumnoById(alumnoId);
        if (response.contains("Alumno no encontrado")) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }  else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @PutMapping("/alumnos/{alumnoId}")
    @Operation(summary = "Actualizar Alumno", description = "Permite actualizar los datos de un alumno según su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alumno modificado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Alumno.class))),
            @ApiResponse(responseCode = "204", description = "No hay contenido en la solicitud")
    })
    @Parameter(description = "El ID del alumno", example = "123")
    public ResponseEntity<String> updateAlumno(@PathVariable int alumnoId, @RequestBody Alumno alumno) {
        String response = alumnoService.updateAlumno(alumnoId, alumno);
        if (response.contains("Alumno no encontrado")) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }  else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @DeleteMapping("/alumnos/{alumnoId}")
    @Operation(summary = "Eliminar Alumno por ID", description = "Elimina un alumno según el ID registrado en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alumno eliminado"),
            @ApiResponse(responseCode = "404", description = "No se encuentran datos")
    })
    @Parameter(description = "El ID del alumno", example = "123")
    public ResponseEntity<String> deleteAlumno(@PathVariable int alumnoId) {
        String response = alumnoService.deleteAlumno(alumnoId);
        if (response.contains("Alumno no encontrado")) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }   else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    // PROFESOR
    @PostMapping("/profesores")
    @Operation(summary = "Agregar Profesor", description = "Permite registrar un profesor en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Profesor creado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Profesor.class))),
            @ApiResponse(responseCode = "204", description = "No hay contenido en la solicitud")
    })
    public ResponseEntity<String> addProfesor(@RequestBody Profesor prof) {
        String response = profesorService.addProfesor(prof);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/profesores/{profesorId}")
    @Operation(summary = "Buscar profesor por ID", description = "Obtiene un profesor según el ID registrado en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna Profesor"),
            @ApiResponse(responseCode = "404", description = "No se encuentran datos")
    })
    @Parameter(description = "El ID del profesor", example = "123")
    public ResponseEntity<String> getProfesoresById(@PathVariable int profesorId) {
        String response = profesorService.getProfesoresById(profesorId);
        if (response.contains("Profesor no encontrado")) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }    else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/profesores")
    @Operation(summary = "Obtener Profesores", description = "Obtiene la lista completa de profesores registrados en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna lista completa de profesores"),
            @ApiResponse(responseCode = "404", description = "No se encuentran datos")
    })
    public ResponseEntity<String> getAllProfesores() {
        String response = profesorService.getAllProfesores();
        if (response.equals("No se encontraron profesores")) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }   else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @PutMapping("/profesores/{profesorId}")
    @Operation(summary = "Actualizar Profesor", description = "Permite actualizar los datos de un profesor según su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profesor modificado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Profesor.class))),
            @ApiResponse(responseCode = "204", description = "No hay contenido en la solicitud")
    })
    @Parameter(description = "El ID del profesor", example = "123")
    public ResponseEntity<String> updateProfesor(@PathVariable int profesorId, @RequestBody Profesor prof) {
        String response = profesorService.updateProfesor(profesorId, prof);
        if (response.contains("Profesor no encontrado")) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }    else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @DeleteMapping("/profesores/{profesorId}")
    @Operation(summary = "Eliminar Profesor por ID", description = "Elimina un profesor según el ID registrado en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profesor eliminado"),
            @ApiResponse(responseCode = "404", description = "No se encuentran datos")
    })
    @Parameter(description = "El ID del profesor", example = "123")
    public ResponseEntity<String> deleteProfesor(@PathVariable int profesorId) {
        String response = profesorService.deleteProfesor(profesorId);
        if (response.contains("Profesor no encontrado")) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    // Curso
    @PostMapping("/cursos")
    @Operation(summary = "Agregar Curso", description = "Permite registrar un curso en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Curso creado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Curso.class))),
            @ApiResponse(responseCode = "204", description = "No hay contenido en la solicitud")
    })
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
    @Operation(summary = "Obtener Cursos", description = "Obtiene la lista completa de los cursos registrados en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna lista completa de cursos"),
            @ApiResponse(responseCode = "404", description = "No se encuentran datos")
    })
    public ResponseEntity<String> getAllCursos() {
        String response = cursoService.getAllCursos();
        if (response.equals("No se encontraron Cursos")) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @DeleteMapping("/cursos/{cursoId}")
    @Operation(summary = "Eliminar Curso por ID", description = "Elimina un curso según el ID registrado en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso eliminado"),
            @ApiResponse(responseCode = "404", description = "No se encuentran datos")
    })
    @Parameter(description = "El ID del curso", example = "123")
    public String deleteCurso(@PathVariable int cursoId) {
        return cursoService.deleteCurso(cursoId);
    }

    @PutMapping("/cursos/{cursoId}")
    @Operation(summary = "Actualizar Curso", description = "Permite actualizar los datos de un curso según su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso modificado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Administrador.class))),
            @ApiResponse(responseCode = "204", description = "No hay contenido en la solicitud")
    })
    @Parameter(description = "El ID del curso", example = "123")
    public String updateCursoAdmin(@PathVariable int cursoId, @RequestBody Curso curso) {
        return cursoService.updateCursoAdmin(cursoId, curso);
    }

    @GetMapping("/cursos/{cursoId}")
    @Operation(summary = "Buscar Curso por ID", description = "Obtiene un curso según el ID registrado en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna Curso"),
            @ApiResponse(responseCode = "404", description = "No se encuentran datos")
    })
    @Parameter(description = "El ID del curso", example = "123")
    public String getCursoById(@PathVariable int cursoId) {
        return cursoService.getCursoById(cursoId);
    }

}
