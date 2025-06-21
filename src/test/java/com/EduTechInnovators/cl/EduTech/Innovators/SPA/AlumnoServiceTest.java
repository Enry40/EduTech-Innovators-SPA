package com.EduTechInnovators.cl.EduTech.Innovators.SPA;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Alumno;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.AlumnoRepository;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.AlumnoServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AlumnoServiceTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AlumnoRepository alumnoRepository;

    @Autowired
    AlumnoServiceImpl alumnoService;

    @Test
    void addAlumnoTest() {
        Alumno alumno = new Alumno();
        alumno.setNombreUsuario("Lucas");
        alumno.setApellidoUsuario("Ramirez");

        String resultado = alumnoService.addAlumno(alumno);

        assertEquals("Alumno creado correctamente", resultado);
        assertEquals("Alumno", alumno.getTipoUsuario());
    }

    @Test
    void getAllAlumnosSizeTest() {
        Alumno alumno1 = new Alumno();
        alumno1.setId(1);
        alumno1.setNombreUsuario("Carla");
        alumno1.setApellidoUsuario("Soto");

        Alumno alumno2 = new Alumno();
        alumno2.setId(2);
        alumno2.setNombreUsuario("Luis");
        alumno2.setApellidoUsuario("Garcia");

        List<Alumno> alumnos = Arrays.asList(alumno1, alumno2);

        Mockito.when(alumnoRepository.findAll()).thenReturn(alumnos);

        String resultado = alumnoService.getAllAlumnos();

        assertNotNull(resultado);
        assertTrue(resultado.contains("Carla"));
        assertTrue(resultado.contains("Luis"));
        assertEquals(2, alumnos.size());
    }

    @Test
    void getAlumnoByIdTest() {
        Alumno alumno = new Alumno();
        alumno.setId(3);
        alumno.setNombreUsuario("Andrea");
        alumno.setApellidoUsuario("Morales");
        alumno.setCorreoAlumno("andrea@duoc.com");
        alumno.setCarrera("Ingenieria Civil");

        Mockito.when(alumnoRepository.existsById(3)).thenReturn(true);
        Mockito.when(alumnoRepository.findById(3)).thenReturn(Optional.of(alumno));

        String resultado = alumnoService.getAlumnoById(3);

        assertNotNull(resultado);
        assertTrue(resultado.contains("Andrea"));
        assertTrue(resultado.contains("Correo: andrea@duoc.com"));
        assertEquals(true, resultado.contains("Carrera: Ingenieria Civil"));
    }

    @Test
    void updateAlumnoTest() {
        Alumno existente = new Alumno();
        existente.setId(5);
        existente.setNombreUsuario("Felipe");

        Alumno actualizado = new Alumno();
        actualizado.setNombreUsuario("Felipe");
        actualizado.setApellidoUsuario("Torres");
        actualizado.setTelefonoUsuario("123456789");
        actualizado.setDireccionUsuario("Calle Alameda (updated)");
        actualizado.setCorreoAlumno("felipe@correo.com");
        actualizado.setCarrera("Matematicas");

        Mockito.when(alumnoRepository.existsById(6)).thenReturn(true);
        Mockito.when(alumnoRepository.findById(6)).thenReturn(Optional.of(existente));

        String resultado = alumnoService.updateAlumno(6, actualizado);

        assertEquals("Alumno actualizado con éxito", resultado);
    }

    @Test
    void deleteAlumnoTest() {
        Mockito.when(alumnoRepository.existsById(10)).thenReturn(true);
        String resultado = alumnoService.deleteAlumno(10);
        assertEquals("Alumno eliminado con éxito", resultado);
    }

    @Test
    void deleteAlumnoNotFoundTest() {
        Mockito.when(alumnoRepository.existsById(80)).thenReturn(false);
        String resultado = alumnoService.deleteAlumno(80);
        assertEquals("Alumno no encontrado", resultado);
    }

}
