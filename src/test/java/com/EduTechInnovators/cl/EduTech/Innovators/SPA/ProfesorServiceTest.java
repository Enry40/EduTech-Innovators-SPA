package com.EduTechInnovators.cl.EduTech.Innovators.SPA;


import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Profesor;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.ProfesorRepository;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.ProfesorServiceImpl;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProfesorServiceTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProfesorRepository profesorRepository;

    @Autowired
    ProfesorServiceImpl profesorService;

    @Test
    void addProfesorTest() {
        Profesor profesor = new Profesor();
        profesor.setNombreUsuario("Luis");
        profesor.setApellidoUsuario("Fernandez");

        String resultado = profesorService.addProfesor(profesor);

        assertEquals("Profesor agregado correctamente", resultado);
        assertEquals("Profesor", profesor.getTipoUsuario());
    }

    @Test
    void getAllProfesoresSizeTest() {
        Profesor profesor1 = new Profesor();
        profesor1.setId(1);
        profesor1.setNombreUsuario("Carlos");
        profesor1.setApellidoUsuario("Perez");

        Profesor profesor2 = new Profesor();
        profesor2.setId(2);
        profesor2.setNombreUsuario("Marta");
        profesor2.setApellidoUsuario("Gomez");

        List<Profesor> profesores = Arrays.asList(profesor1, profesor2);

        Mockito.when(profesorRepository.findAll()).thenReturn(profesores);

        String resultado = profesorService.getAllProfesores();

        assertNotNull(resultado);
        assertTrue(resultado.contains("Carlos"));
        assertTrue(resultado.contains("Marta"));
        assertEquals(2, profesores.size());
    }

    @Test
    void getProfesorByIdTest() {
        Profesor profesor = new Profesor();
        profesor.setId(3);
        profesor.setNombreUsuario("Ana");
        profesor.setApellidoUsuario("Martinez");
        profesor.setCorreoProfe("ana@duoc.com");
        profesor.setAsignatura("Matematicas");
        profesor.setEspecialidad("Algebra");

        Mockito.when(profesorRepository.existsById(3)).thenReturn(true);
        Mockito.when(profesorRepository.findById(3)).thenReturn(Optional.of(profesor));

        String resultado = profesorService.getProfesoresById(3);

        assertNotNull(resultado);
        assertTrue(resultado.contains("Ana"));
        assertTrue(resultado.contains("Correo: ana@duoc.com"));
        assertTrue(resultado.contains("Especialidad: Algebra"));
    }

    @Test
    void updateProfesorTest() {
        Profesor existente = new Profesor();
        existente.setId(4);
        existente.setNombreUsuario("Pedro");

        Profesor actualizado = new Profesor();
        actualizado.setNombreUsuario("Pedro Actualizado");
        actualizado.setApellidoUsuario("Sanchez");
        actualizado.setTelefonoUsuario("987654321");
        actualizado.setDireccionUsuario("Calle Coquinbo 123");
        actualizado.setCorreoProfe("pedro@duoc.com");
        actualizado.setAsignatura("Fisica");
        actualizado.setEspecialidad("Mecanica Cuantica");

        Mockito.when(profesorRepository.existsById(4)).thenReturn(true);
        Mockito.when(profesorRepository.findById(4)).thenReturn(Optional.of(existente));

        String resultado = profesorService.updateProfesor(4, actualizado);

        assertEquals("Profesor actualizado con éxito", resultado);
    }

    @Test
    void deleteProfesorTest() {
        Mockito.when(profesorRepository.existsById(10)).thenReturn(true);
        String resultado = profesorService.deleteProfesor(10);
        assertEquals("Profesor eliminado con exito", resultado);
    }

    @Test
    void deleteProfesorNotFoundTest() {
        Mockito.when(profesorRepository.existsById(10)).thenReturn(false);
        String resultado = profesorService.deleteProfesor(10);
        assertEquals("El profesor no existe", resultado);
    }

    @Test
    void updateProfesorProTest() {
        Profesor existente = new Profesor();
        existente.setId(6);
        existente.setNombreUsuario("Laura");

        Profesor actualizado = new Profesor();
        actualizado.setTelefonoUsuario("123456789");
        actualizado.setDireccionUsuario("Av. Libertad 456");
        actualizado.setEspecialidad("Programacion");

        Mockito.when(profesorRepository.existsById(6)).thenReturn(true);
        Mockito.when(profesorRepository.findById(6)).thenReturn(Optional.of(existente));

        String resultado = profesorService.updateProfesorPro(6, actualizado);

        assertEquals("Datos actualizados con exito", resultado);
    }


}
