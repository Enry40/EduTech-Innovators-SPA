package com.EduTechInnovators.cl.EduTech.Innovators.SPA.controller;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Alumno;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.AlumnoServiceImpl;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.CursoService;
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

}
