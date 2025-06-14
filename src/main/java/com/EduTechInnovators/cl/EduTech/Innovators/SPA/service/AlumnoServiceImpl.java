package com.EduTechInnovators.cl.EduTech.Innovators.SPA.service;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Alumno;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public String addAlumno(Alumno alu) {
        alu.setTipoUsuario("Alumno");
        alumnoRepository.save(alu);
        return "Alumno creado correctamente";
    }

    @Override
    public String getAllAlumnos() {
        String output = "";
        for (Alumno alu : alumnoRepository.findAll()) {
            output += "ID Alumno: " + alu.getId() + "\n";
            output += "Nombre: " + alu.getNombreUsuario() + "\n";
            output += "Apellido: " + alu.getApellidoUsuario() + "\n";
            output += "Telefono: " + alu.getTelefonoUsuario() + "\n";
            output += "Direccion: " + alu.getDireccionUsuario() + "\n";
            output += "Correo: " + alu.getCorreoAlumno() + "\n";
            output += "Carrera: " + alu.getCarrera() + "\n";
        }
        if (output.isEmpty()) {
            return "No se encontraron alumnos";
        } else {
            return output;
        }
    }

    @Override
    public String getAlumnoById(int id) {
        String output = "";
        if (alumnoRepository.existsById(id)) {
            Alumno alu = alumnoRepository.findById(id).get();
            output += "ID Alumno: " + alu.getId() + "\n";
            output += "Nombre: " + alu.getNombreUsuario() + "\n";
            output += "Apellido: " + alu.getApellidoUsuario() + "\n";
            output += "Telefono: " + alu.getTelefonoUsuario() + "\n";
            output += "Direccion: " + alu.getDireccionUsuario() + "\n";
            output += "Correo: " + alu.getCorreoAlumno() + "\n";
            output += "Carrera: " + alu.getCarrera() + "\n";
            return output;
        } else {
            return "Alumno no encontrado";
        }
    }

    @Override
    public String updateAlumno(int id, Alumno alu) {
        if (alumnoRepository.existsById(id)) {
            Alumno buscado = alumnoRepository.findById(id).get();
            buscado.setNombreUsuario(alu.getNombreUsuario());
            buscado.setApellidoUsuario(alu.getApellidoUsuario());
            buscado.setTelefonoUsuario(alu.getTelefonoUsuario());
            buscado.setDireccionUsuario(alu.getDireccionUsuario());
            buscado.setCorreoAlumno(alu.getCorreoAlumno());
            buscado.setCarrera(alu.getCarrera());
            alumnoRepository.save(buscado);
            return "Alumno actualizado con éxito";
        } else {
            return "Alumno no encontrado";
        }
    }

    @Override
    public String deleteAlumno(int id) {
        if (alumnoRepository.existsById(id)) {
            alumnoRepository.deleteById(id);
            return "Alumno eliminado con éxito";
        } else {
            return "Alumno no encontrado";
        }
    }
}
