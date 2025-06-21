package com.EduTechInnovators.cl.EduTech.Innovators.SPA;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Alumno;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Curso;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Profesor;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.AlumnoRepository;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.CursoRepository;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.ProfesorRepository;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.CursoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CursoServiceTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CursoRepository cursoRepository;

    @MockBean
    AlumnoRepository alumnoRepository;

    @MockBean
    ProfesorRepository profesorRepository;

    @Autowired
    CursoService cursoService;

    @Test
    void addCursoTest() {
        Curso curso = new Curso();
        curso.setNombreCurso("Matematicas");
        curso.setDescripcionCurso("Curso basico de matematicas");
        curso.setEvaluacionCurso(90);

        String resultado = cursoService.addCurso(curso);

        assertEquals("Curso creado correctamente", resultado);
    }

    @Test
    void addAlumnoCursoTest() {
        Curso curso = new Curso();
        curso.setIdCurso(1);
        Alumno alumno = new Alumno();
        alumno.setId(2);
        alumno.setNombreUsuario("Carlos");

        Mockito.when(cursoRepository.findById(1)).thenReturn(Optional.of(curso));
        Mockito.when(alumnoRepository.findById(2)).thenReturn(Optional.of(alumno));

        List<String> mensajes = cursoService.addAlumnoCurso(1, 2);

        assertNotNull(mensajes);
        assertTrue(mensajes.contains("Alumno registrado correctamente"));
    }

    @Test
    void addAlumnoCursoAlreadyRegisteredTest() {
        Curso curso = new Curso();
        curso.setIdCurso(1);
        Alumno alumno = new Alumno();
        alumno.setId(2);
        alumno.setNombreUsuario("Carlos");

        curso.getAlumnos().add(alumno);

        Mockito.when(cursoRepository.findById(1)).thenReturn(Optional.of(curso));
        Mockito.when(alumnoRepository.findById(2)).thenReturn(Optional.of(alumno));

        List<String> mensajes = cursoService.addAlumnoCurso(1, 2);

        assertNotNull(mensajes);
        assertTrue(mensajes.contains("El alumno ya se encuentra registrado"));
    }

    @Test
    void addProfesorCursoTest() {
        Curso curso = new Curso();
        curso.setIdCurso(1);
        Profesor profesor = new Profesor();
        profesor.setId(3);
        profesor.setNombreUsuario("Juan");

        Mockito.when(cursoRepository.findById(1)).thenReturn(Optional.of(curso));
        Mockito.when(profesorRepository.findById(3)).thenReturn(Optional.of(profesor));

        List<String> mensajes = cursoService.addProfesorCurso(1, 3);

        assertNotNull(mensajes);
        assertTrue(mensajes.contains("Profesor registrado correctamente"));
    }

    @Test
    void addProfesorCursoAlreadyRegisteredTest() {
        Curso curso = new Curso();
        curso.setIdCurso(1);
        Profesor profesor = new Profesor();
        profesor.setId(3);
        profesor.setNombreUsuario("Juan");

        curso.getProfesores().add(profesor);

        Mockito.when(cursoRepository.findById(1)).thenReturn(Optional.of(curso));
        Mockito.when(profesorRepository.findById(3)).thenReturn(Optional.of(profesor));

        List<String> mensajes = cursoService.addProfesorCurso(1, 3);

        assertNotNull(mensajes);
        assertTrue(mensajes.contains("El profesor ya se encuentra registrado"));
    }

    @Test
    void getAllCursosTest() {
        Curso curso1 = new Curso();
        curso1.setIdCurso(1);
        curso1.setNombreCurso("Matematicas");

        Curso curso2 = new Curso();
        curso2.setIdCurso(2);
        curso2.setNombreCurso("Fisica");

        List<Curso> cursos = Arrays.asList(curso1, curso2);

        Mockito.when(cursoRepository.findAll()).thenReturn(cursos);

        String resultado = cursoService.getAllCursos();

        assertNotNull(resultado);
        assertTrue(resultado.contains("Matematicas"));
        assertTrue(resultado.contains("Fisica"));
    }

    @Test
    void deleteCursoTest() {
        Mockito.when(cursoRepository.existsById(1)).thenReturn(true);
        String resultado = cursoService.deleteCurso(1);
        assertEquals("Curso eliminado correctamente", resultado);
    }

    @Test
    void deleteCursoNotFoundTest() {
        Mockito.when(cursoRepository.existsById(999)).thenReturn(false);
        String resultado = cursoService.deleteCurso(999);
        assertEquals("No se ha encontrado el curso", resultado);
    }

    @Test
    void updateCursoProfeTest() {
        Curso curso = new Curso();
        curso.setIdCurso(1);
        curso.setEvaluacionCurso(85);

        Mockito.when(cursoRepository.existsById(1)).thenReturn(true);
        Mockito.when(cursoRepository.findById(1)).thenReturn(Optional.of(curso));

        String resultado = cursoService.updateCursoProfe(1, curso);

        assertEquals("Evaluaciones actualizadas correctamente", resultado);
    }

    @Test
    void updateCursoAdminTest() {
        Curso curso = new Curso();
        curso.setIdCurso(2);
        curso.setNombreCurso("Fisica");
        curso.setEvaluacionCurso(90);

        Mockito.when(cursoRepository.existsById(2)).thenReturn(true);
        Mockito.when(cursoRepository.findById(2)).thenReturn(Optional.of(curso));

        String resultado = cursoService.updateCursoAdmin(2, curso);

        assertEquals("Curso actualizado correctamente", resultado);
    }

    @Test
    void getCursoByIdTest() {
        Curso curso = new Curso();
        curso.setIdCurso(1);
        curso.setNombreCurso("Quimica");

        Mockito.when(cursoRepository.existsById(1)).thenReturn(true);
        Mockito.when(cursoRepository.findById(1)).thenReturn(Optional.of(curso));

        String resultado = cursoService.getCursoById(1);

        assertNotNull(resultado);
        assertTrue(resultado.contains("Quimica"));
    }

    @Test
    void getCursoByIdNotFoundTest() {
        Mockito.when(cursoRepository.existsById(89)).thenReturn(false);

        String resultado = cursoService.getCursoById(89);

        assertEquals("No se ha encontrado el curso", resultado);
    }

}
