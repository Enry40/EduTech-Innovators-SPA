package com.EduTechInnovators.cl.EduTech.Innovators.SPA.service;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Administrador;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Estudiante;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Profesor;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.AdministradorRepository;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.EstudianteRepository;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

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

    public String addEstudiante(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
        return "Estudiante creado";
    }

    public String getEstudianteById(int id){
        String output = "";
        if (estudianteRepository.existsById(id)){
            Estudiante estudiante = estudianteRepository.findById(id).get();
            output += "ID Estudiante: " + estudiante.getIdEstudiante() + "\n";
            output += "Nombre: " + estudiante.getNombreEstudiante() +"\n";
            output += "Cursos Inscritos: " + estudiante.getCursosInscritos() +"\n";
            return output;
        } else {
            return "No existe el estudiante";
        }
    }

    public String updateEstudiante(int id, Estudiante estudiante){
        if (estudianteRepository.existsById(id)){
            Estudiante buscado = usuarioRepository.findById(id).get();
            buscado.setNombreEstudiante(estudiante.getNombreEstudiante());
            buscado.setCursosInscritos(estudiante.getCursosInscritos());
            return "Estudiante actualizado";
        } else{
            return "No existe el estudiante";
        }
    }

    public String deleteEstudiante(int id){
        if (estudianteRepository.existsById(id)){
            estudianteRepository.deleteById(id);
            return "Estudiante eliminado";
        }
    }

    public String getAllEstudiantes() {
        String output = "";
        for (Estudiante estudiante : estudianteRepository.findAll()) {
            output += "ID Estudiante " + estudiante.getIdEstudiante() + "\n";
            output += "Nombre: " + estudiante.getNombreEstudiante() + "\n";
            output += "Cursos: " + estudiante.getCursosInscritos() + "\n";
        }
        if (output.isEmpty()){
            return "No se encontraron estudiantes";
        } else {
            return output;
        }
    }

    public String addProfesor(Profesor profesor) {
        profesorRepository.save(profesor);
        return "Profesor creado";
    }

    public String getProfesorById(int id){
        String output = "";
        if (profesorRepository.existsById(id)){
            Profesor profesor = profesorRepository.findById(id).get();
            output += "ID Profesor: " + profesor.getIdProfesor() + "\n";
            output += "Nombre: " + profesor.getNombreProfesor() + "\n";
            output += "Asignatura: " + profesor.getAsignatura() + "\n";
            return output;
        } else {
            return "No existe el profesor";
        }
    }

    public String updateProfesor(int id, Profesor profesor){
        if (profesorRepository.existsById(id)){
            Profesor buscado = profesorRepository.findById(id).get();
            buscado.setNombreProfesor(profesor.getNombreProfesor());
            buscado.setAsignatura(profesor.getAsignatura());
            return "Profesor actualizado";
        } else {
            return "No existe el profesor";
        }
    }

    public String deleteProfesor(int id){
        if (profesorRepository.existsById(id)){
            profesorRepository.deleteById(id);
            return "Profesor eliminado";
        }
    }

    public String getAllProfesores() {
        String output = "";
        for (Profesor profesor : profesorRepository.findAll()) {
            output += "ID Profesor: " + profesor.getIdProfesor() + "\n";
            output += "Nombre: " + profesor.getNombreProfesor() + "\n";
            output += "Asignatura: " + profesor.getAsignatura() + "\n";
        }
        if (output.isEmpty()){
            return "No se encontraron profesores";
        }
    }



}
