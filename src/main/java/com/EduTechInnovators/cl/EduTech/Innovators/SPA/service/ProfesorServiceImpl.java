package com.EduTechInnovators.cl.EduTech.Innovators.SPA.service;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Profesor;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.AlumnoRepository;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.CursoRepository;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public String addProfesor(Profesor profe) {
        profe.setTipoUsuario("Profesor");
        profesorRepository.save(profe);
        return "Profesor agregado correctamente";
    }

    @Override
    public String deleteProfesor(int id) {
        if (profesorRepository.existsById(id)) {
            profesorRepository.deleteById(id);
            return "Profesor eliminado con exito";
        } else {
            return "El profesor no existe";
        }
    }

    @Override
    public String updateProfesor(int id, Profesor profe) {
        if (profesorRepository.existsById(id)) {
            Profesor buscado = profesorRepository.findById(id).get();
            buscado.setNombreUsuario(profe.getNombreUsuario());
            buscado.setApellidoUsuario(profe.getApellidoUsuario());
            buscado.setTelefonoUsuario(profe.getTelefonoUsuario());
            buscado.setDireccionUsuario(profe.getDireccionUsuario());
            buscado.setCorreoProfe(profe.getCorreoProfe());
            buscado.setAsignatura(profe.getAsignatura());
            buscado.setEspecialidad(profe.getEspecialidad());
            profesorRepository.save(buscado);
            return "Profesor actualizado con éxito";
        } else {
            return "Profesor no encontrado";
        }
    }

    @Override
    public String getProfesoresById(int id) {
        String output = "";
        if (profesorRepository.existsById(id)) {
            Profesor profe = profesorRepository.findById(id).get();
            output += "ID Profesor: " + profe.getId() + "\n";
            output += "Nombre: " + profe.getNombreUsuario() + "\n";
            output += "Apellido: " + profe.getApellidoUsuario() + "\n";
            output += "Telefono: " + profe.getTelefonoUsuario() + "\n";
            output += "Direccion: " + profe.getDireccionUsuario() + "\n";
            output += "Correo: " + profe.getCorreoProfe() + "\n";
            output += "Asignatura: " + profe.getAsignatura() + "\n";
            output += "Especialidad: " + profe.getEspecialidad() + "\n";
            return output;
        } else {
            return "Profesor no encontrado";
        }
    }

    @Override
    public String getAllProfesores() {
        String output = "";
        for (Profesor profe : profesorRepository.findAll()) {
            output += "ID Profesor: " + profe.getId() + "\n";
            output += "Nombre: " + profe.getNombreUsuario() + "\n";
            output += "Apellido: " + profe.getApellidoUsuario() + "\n";
            output += "Telefono: " + profe.getTelefonoUsuario() + "\n";
            output += "Direccion: " + profe.getDireccionUsuario() + "\n";
            output += "Correo: " + profe.getCorreoProfe() + "\n";
            output += "Asignatura: " + profe.getAsignatura() + "\n";
            output += "Especialidad: " + profe.getEspecialidad() + "\n";
        }
        if (output.isEmpty()) {
            return "No se encontraron profesores";
        } else {
            return output;
        }
    }

    @Override
    public String updateProfesorPro(int id, Profesor profe) {
        if (profesorRepository.existsById(id)) {
            Profesor buscado = profesorRepository.findById(id).get();
            buscado.setTelefonoUsuario(profe.getTelefonoUsuario());
            buscado.setDireccionUsuario(profe.getDireccionUsuario());
            buscado.setEspecialidad(profe.getEspecialidad());
            profesorRepository.save(buscado);
            return "Datos actualizados con exito";
        } else {
            return "Profesor no encontrado";
        }
    }
}
