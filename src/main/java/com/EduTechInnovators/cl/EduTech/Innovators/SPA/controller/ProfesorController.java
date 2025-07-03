package com.EduTechInnovators.cl.EduTech.Innovators.SPA.controller;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Curso;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Profesor;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.CursoService;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.ProfesorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorServiceImpl profesorService;

    private final CursoService cursoService;
    @Autowired
    public ProfesorController(
            CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PutMapping("/{profesorId}")
    @Operation(summary = "Actualizar Profesor", description = "Permite actualizar los datos de un profesor según su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profesor modificado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Profesor.class))),
            @ApiResponse(responseCode = "204", description = "No hay contenido en la solicitud")
    })
    @Parameter(description = "El ID del profesor", example = "123")
    public ResponseEntity<String> updateProfesorPro(@PathVariable int profesorId, @RequestBody Profesor profe) {
        String response = profesorService.updateProfesor(profesorId, profe);
        if (response.contains("Profesor no encontrado")) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
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

    @PutMapping("/cursos/{cursoId}")
    @Operation(summary = "Buscar curso por ID", description = "Obtiene un curso según el ID registrado en el sistema para cargar evaluaciones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna curso"),
            @ApiResponse(responseCode = "404", description = "No se encuentran datos")
    })
    @Parameter(description = "El ID del curso", example = "123")
    public String updateCursoProfe(@PathVariable int cursoId, @RequestBody Curso curso) {
        return cursoService.updateCursoProfe(cursoId, curso);
    }

}
