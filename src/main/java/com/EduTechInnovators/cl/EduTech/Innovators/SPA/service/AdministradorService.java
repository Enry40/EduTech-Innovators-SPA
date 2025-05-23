package com.EduTechInnovators.cl.EduTech.Innovators.SPA.service;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Administrador;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Curso;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Estudiante;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Profesor;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.AdministradorRepository;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.CursoRepository;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.EstudianteRepository;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public  String addAdministrador(Administrador admin){
        administradorRepository.save(admin);
        return "Administrador creado";
    }

    public String getAdministradorById(int id){
        String output = "";
        if (administradorRepository.existsById(id)){
            Administrador admin = administradorRepository.findById(id).get();
            output += "ID Administrador: " + admin.getIdAdmin() + "\n";
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
            Estudiante buscado = estudianteRepository.findById(id).get();
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
        } else {
            return "No existe el estudiante";
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
        } else {
            return "No existe el profesor";
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
        } else {
            return output;
        }
    }

    public String addCurso(Curso curso) {
        cursoRepository.save(curso);
        return "Curso creado";
    }

    public String getCursoById(int id){
        String output = "";
        if (cursoRepository.existsById(id)){
            Curso curso = cursoRepository.findById(id).get();
            output += "ID Curso: " + curso.getIdCurso() + "\n";
            output += "Nombre: " + curso.getNombreCurso() + "\n";
            output += "Descripcion: " + curso.getDescripcionCurso() + "\n";
            return output;
        } else {
            return "No existe el curso";
        }
    }

    public String updateCurso(int id, Curso curso){
        if (cursoRepository.existsById(id)){
            Curso buscado = cursoRepository.findById(id).get();
            buscado.setNombreCurso(curso.getNombreCurso());
            buscado.setDescripcionCurso(curso.getDescripcionCurso());
            return "Curso actualizado";
        } else {
            return "No existe el curso";
        }
    }

    public String deleteCurso(int id){
        if (cursoRepository.existsById(id)){
            cursoRepository.deleteById(id);
            return "Curso eliminado";
        } else {
            return "No existe el curso";
        }
    }

    public String getAllCursos() {
        String output = "";
        for (Curso curso : cursoRepository.findAll()) {
            output += "ID Curso: " + curso.getIdCurso() + "\n";
            output += "Nombre: " + curso.getNombreCurso() + "\n";
            output += "Descripcion: " + curso.getDescripcionCurso() + "\n";
        }
        if (output.isEmpty()){
            return "No se encontraron Cursos";
        } else {
            return output;
        }
    }

}
