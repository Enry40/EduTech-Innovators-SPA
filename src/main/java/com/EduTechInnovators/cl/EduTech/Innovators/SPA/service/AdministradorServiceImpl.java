package com.EduTechInnovators.cl.EduTech.Innovators.SPA.service;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Administrador;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.AdministradorRepository;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorServiceImpl implements AdministradorService{

    @Autowired
    private final UsuarioRepository usuarioRepository;

    @Autowired
    private final AdministradorRepository administradorRepository;

    public AdministradorServiceImpl(UsuarioRepository usuarioRepository,
                                    AdministradorRepository administradorRepository) {
        this.usuarioRepository = usuarioRepository;
        this.administradorRepository = administradorRepository;
    }

    @Override
    public String addAdmin(Administrador admin) {
        admin.setTipoUsuario("Administrador");
        administradorRepository.save(admin);
        return "Administrador creado correctamente";
    }

    @Override
    public String getAllAdmin() {
        String output = "";
        for (Administrador admin : administradorRepository.findAll()) {
            output += "ID Administrador: " + admin.getId() + "\n";
            output += "Nombre: " + admin.getNombreUsuario() + "\n";
            output += "Apellido: " + admin.getApellidoUsuario() + "\n";
            output += "Telefono: " + admin.getTelefonoUsuario() + "\n";
            output += "Direccion: " + admin.getDireccionUsuario() + "\n";
        }
        if (output.isEmpty()) {
            return "No se encontraron administradores";
        } else {
            return output;
        }
    }

    @Override
    public String getAdminById(int id) {
        String output = "";
        if (administradorRepository.existsById(id)) {
            Administrador admin = administradorRepository.findById(id).get();
            output += "ID Administrador: " + admin.getId() + "\n";
            output += "Nombre: " + admin.getNombreUsuario() + "\n";
            output += "Apellido: " + admin.getApellidoUsuario() + "\n";
            output += "Telefono: " + admin.getTelefonoUsuario() + "\n";
            output += "Direccion: " + admin.getDireccionUsuario() + "\n";
            return output;
        } else {
            return "Administrador no encontrado";
        }
    }

    @Override
    public String deleteAdmin(int id) {
        if (administradorRepository.existsById(id)) {
            administradorRepository.deleteById(id);
            return "Administrador eliminado con exito";
        } else {
            return "Administrador no encontrado";
        }
    }

    @Override
    public String updateAdmin(int id, Administrador admin) {
        if (administradorRepository.existsById(id)) {
            Administrador buscado = administradorRepository.findById(id).get();
            buscado.setNombreUsuario(admin.getNombreUsuario());
            buscado.setApellidoUsuario(admin.getApellidoUsuario());
            buscado.setTelefonoUsuario(admin.getTelefonoUsuario());
            buscado.setDireccionUsuario(admin.getDireccionUsuario());
            buscado.setCorreoAdmin(admin.getCorreoAdmin());
            administradorRepository.save(buscado);
            return "Administrador actualizado con exito";
        } else {
            return "Administrador no encontrado";
        }
    }
}
