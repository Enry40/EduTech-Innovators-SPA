package com.EduTechInnovators.cl.EduTech.Innovators.SPA.controller;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.administrador;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.administradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrador")
public class administradorController {

    @Autowired
    private administradorService administradorService;

    @GetMapping
    public String getAllAdministrador() {
        return administradorService.getAllAdministrador();
    }

    @GetMapping("/{id}")
    public String getUserById (@PathVariable int id) {
        return administradorService.getUserById(id);
    }

    @PostMapping
    public String addAdministrador(@RequestBody administrador administrador) {
        return administradorService.addAdministrador(administrador);
    }

    @DeleteMapping("/{id}")
    public String deleteAdministrador(@PathVariable int id) {
        return administradorService.deleteAdministrador(id);
    }

    @PutMapping("/{id}")
    public String updateAdministrador(@PathVariable int id, @RequestBody administrador administrador) {
        return administradorService.updateAdministrador(id, administrador);
    }

}
