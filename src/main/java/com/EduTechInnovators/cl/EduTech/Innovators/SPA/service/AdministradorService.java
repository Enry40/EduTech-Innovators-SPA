package com.EduTechInnovators.cl.EduTech.Innovators.SPA.service;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Administrador;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Usuario;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.AdministradorRepository;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public  String addAdministrador(Administrador admin){
        administradorRepository.save(admin);
        return "Administrador creado";
    }

    public  String getAdministradorById(int id){
        String output = "";
        if (administradorRepository.existsById(id)){
            return output;
        } else{
            return "No existe el administrador";
        }
    }

    public  String deleteAdministrador(int id){
        if (administradorRepository.existsById(id)){
            administradorRepository.deleteById(id);
            return "Administrador eliminado";
        } else{
            return "No existe el administrador";
        }
    }

    public String addUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
        return "Usuario creado";
    }

    public String getUsuarioById(int id){
        String output = "";
        if (usuarioRepository.existsById(id)){
            Usuario usuario = usuarioRepository.findById(id).get();
            output += "ID Usuario: " + usuario.getIdUsuario() + "\n";
            output += "Nombre: " + usuario.getNombreUsuario() +"\n";
            output += "Contrasenia: " + usuario.getContrasenia() +"\n";
            output += "Correo: " + usuario.getCorreo() +"\n";
            output += "Tipo de usuario: " + usuario.getTipoUsuario() +"\n";
            return output;
        } else{
            return "No existe el usuario";
        }
    }

    public String updateUsuario(int id, Usuario usuario){
        if (usuarioRepository.existsById(id)){
            Usuario buscado = usuarioRepository.findById(id).get();
            buscado.setNombreUsuario(usuario.getNombreUsuario());
            buscado.setContrasenia(usuario.getContrasenia());
            buscado.setCorreo(usuario.getCorreo());
            buscado.setTipoUsuario(usuario.getTipoUsuario());
            return "Usuario actualizado";
        } else{
            return "No existe el usuario";
        }
    }

    public  String deleteUsuario(int id){
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return "Usuario eliminado";
        } else{
            return "No existe el usuario";
        }
    }

    public String getAllUsuarios() {
        String output = "";
        for (Usuario usuario : usuarioRepository.findAll()) {
            output += "ID Usuario: " + usuario.getIdUsuario() + "\n";
            output += "Nombre: " + usuario.getNombreUsuario() +"\n";
            output += "Contrasenia: " + usuario.getContrasenia() +"\n";
            output += "Correo: " + usuario.getCorreo() +"\n";
            output += "Tipo de usuario: " + usuario.getTipoUsuario() +"\n";
        }
        if (output.isEmpty()){
            return "No se encontraron usuarios";
        }else{
            return output;
        }
    }




}
