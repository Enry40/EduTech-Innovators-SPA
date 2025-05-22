package com.EduTechInnovators.cl.EduTech.Innovators.SPA.controller;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Administrador;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Usuario;
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

   @ PostMapping("/usuario")
    public String addUsuario(@RequestBody Usuario usuario) {
        return administradorService.addUsuario(usuario);
    }

    @GetMapping("/usuario/{id}")
    public String getUsuarioById(@PathVariable int id) {
        return administradorService.getUsuarioById(id);
    }

    @PutMapping("/usuario/{id}")
    public String updateUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        return administradorService.updateUsuario(id, usuario);
    }

    @DeleteMapping("/usuario/{id}")
    public String deleteUsuario(@PathVariable int id) {
        return administradorService.deleteUsuario(id);
    }

    @GetMapping("/usuario")
    public String getAllUsuarios() {
        return administradorService.getAllUsuarios();
    }

}
