package com.EduTechInnovators.cl.EduTech.Innovators.SPA;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Administrador;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.AdministradorRepository;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.UsuarioRepository;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.AdministradorServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class AdministradorServicesTest {

    @Autowired
    MockMvc mockMvc;

     @MockBean
    AdministradorRepository administradorRepository;

     @MockBean
    UsuarioRepository usuarioRepository;

     @Autowired
    AdministradorServiceImpl administradorService;

     @Test
    void addAdminTest() {
         Administrador admin = new Administrador();
         admin.setNombreUsuario("Juan");
         admin.setApellidoUsuario("Valdez");

         String resultado = administradorService.addAdmin(admin);
         assertEquals("Administrador creado correctamente", resultado);
         assertEquals("Administrador", admin.getTipoUsuario());

     }

    @Test
    void getAllAdminTest() {
        Administrador admin = new Administrador();
        admin.setId(1);
        admin.setNombreUsuario("Juan");
        admin.setApellidoUsuario("Valdez");
        admin.setTelefonoUsuario("123456789");
        admin.setDireccionUsuario("Av. Antonio Varas 666");

        Mockito.when(administradorRepository.findAll()).thenReturn(Arrays.asList(admin));

        String resultado = administradorService.getAllAdmin();
        assertTrue(resultado.contains("Juan"));
        assertTrue(resultado.contains("ID Administrador: 1"));

    }

    @Test
    void getAdminByIdFoundTest() {
        Administrador admin = new Administrador();
        admin.setId(2);
        admin.setNombreUsuario("Ana");
        admin.setApellidoUsuario("Martínez");
        admin.setTelefonoUsuario("987654321");
        admin.setDireccionUsuario("Av. Pio Nono 123");

        Mockito.when(administradorRepository.existsById(2)).thenReturn(true);
        Mockito.when(administradorRepository.findById(2)).thenReturn(Optional.of(admin));

        String resultado = administradorService.getAdminById(2);
        assertTrue(resultado.contains("Ana"));
        assertTrue(resultado.contains("ID Administrador: 2"));
    }

    @Test
    void getAdminByIdNotFoundTest() {
        Mockito.when(administradorRepository.existsById(69)).thenReturn(false);
        String resultado = administradorService.getAdminById(69);
        assertEquals("Administrador no encontrado", resultado);
    }

    @Test
    void updateAdminTest() {
        Administrador existente = new Administrador();
        existente.setId(5);
        existente.setNombreUsuario("Carlos");

        Administrador actualizado = new Administrador();
        actualizado.setNombreUsuario("Carlos");
        actualizado.setApellidoUsuario("Gómez");
        actualizado.setTelefonoUsuario("148953256");
        actualizado.setDireccionUsuario("Moneda 45 (updated)");
        actualizado.setCorreoAdmin("carlos@algo.com");

        Mockito.when(administradorRepository.existsById(5)).thenReturn(true);
        Mockito.when(administradorRepository.findById(5)).thenReturn(Optional.of(existente));

        String resultado = administradorService.updateAdmin(5, actualizado);
        assertEquals("Administrador actualizado con exito", resultado);
    }

    @Test
    void deleteAdminTest() {
        Mockito.when(administradorRepository.existsById(3)).thenReturn(true);
        String resultado = administradorService.deleteAdmin(3);
        assertEquals("Administrador eliminado con exito", resultado);
    }

    @Test
    void deleteAdminNotFoundTest() {
        Mockito.when(administradorRepository.existsById(33)).thenReturn(false);
        String resultado = administradorService.deleteAdmin(33);
        assertEquals("Administrador no encontrado", resultado);
    }
}

