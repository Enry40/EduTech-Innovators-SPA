package com.EduTechInnovators.cl.EduTech.Innovators.SPA.service;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Alumno;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Curso;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Profesor;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.AlumnoRepository;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.CursoRepository;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    private final AlumnoRepository alumnoRepository;

    private final ProfesorRepository profesorRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository, AlumnoRepository alumnoRepository,
                        ProfesorRepository profesorRepository) {
        this.cursoRepository = cursoRepository;
        this.alumnoRepository = alumnoRepository;
        this.profesorRepository = profesorRepository;
    }

    public String addCurso(Curso curso) {
        cursoRepository.save(curso);
        return  "Curso creado correctamente";
    }

    public List<String> addAlumnoCurso (int idCurso, int idAlumno) {
        List<String> mensajes = new ArrayList<>();
        Optional<Curso> cursoOpt = cursoRepository.findById(idCurso);
        Optional<Alumno> alumnoOpt= alumnoRepository.findById(idAlumno);

        if (cursoOpt.isEmpty()) {
            mensajes.add("El curso no existe");
            return mensajes;
        }
        if (alumnoOpt.isEmpty()) {
            mensajes.add("El alumno no existe");
            return mensajes;
        }

        Curso curso = cursoOpt.get();
        Alumno alumno = alumnoOpt.get();

        mensajes.addAll(curso.addAlumnoCurso(alumno));
        cursoRepository.save(curso);
        return  mensajes;
    }

    public List<String> addProfesorCurso (int idCurso, int idProfesor) {
        List<String> mensajes = new ArrayList<>();
        Optional<Curso> cursoOpt = cursoRepository.findById(idCurso);
        Optional<Profesor> profesorOpt = profesorRepository.findById(idProfesor);

        if (cursoOpt.isEmpty()) {
            mensajes.add("El curso no existe");
            return mensajes;
        }
        if (profesorOpt.isEmpty()) {
            mensajes.add("El profesor no existe");
            return mensajes;
        }

        Curso curso = cursoOpt.get();
        Profesor profesor = profesorOpt.get();

        mensajes.addAll(curso.addProfesorCurso(profesor));
        cursoRepository.save(curso);
        return  mensajes;
    }

    public String getAllCursos() {
        String output = "";
        for (Curso curso : cursoRepository.findAll()) {
            output += "ID Curso: " + curso.getIdCurso() + "\n";
            output += "Nombre: " + curso.getNombreCurso() + "\n";
            output += "Alumnos: " + curso.getAlumnos() + "\n";
            output += "Evaluaciones: " + curso.getEvaluacionCurso() + "\n";
            output += "Profesor: " + curso.getProfesores() + "\n";
        }
        if (output.isEmpty()) {
            return "No se ha encontrado el curso";
        } else {
            return output;
        }
    }

    public String deleteCurso(int id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
            return "Curso eliminado correctamente";
        } else {
            return "No se ha encontrado el curso";
        }
    }

    public String updateCursoProfe(int id, Curso curso) {
        if (cursoRepository.existsById(id)) {
            Curso cur = cursoRepository.findById(id).get();
            cur.setEvaluacionCurso(curso.getEvaluacionCurso());
            cursoRepository.save(cur);
            return "Evaluaciones actualizadas correctamente";
        } else {
            return "No se ha encontrado el curso";
        }
    }

    public String updateCursoAdmin(int id, Curso curso) {
        if (cursoRepository.existsById(id)) {
            Curso cur = cursoRepository.findById(id).get();
            cur.setNombreCurso(curso.getNombreCurso());
            cur.setAlumnos(curso.getAlumnos());
            cur.setEvaluacionCurso(curso.getEvaluacionCurso());
            cur.setProfesores(curso.getProfesores());
            cursoRepository.save(cur);
            return "Curso actualizado correctamente";
        }  else {
            return "No se ha encontrado el curso";
        }
    }

    public String getCursoById(int id) {
        String output = "";
        if (cursoRepository.existsById(id)) {
            Curso buscado = cursoRepository.findById(id).get();
            output = "ID Curso: " + buscado.getIdCurso() + "\n";
            output += "Nombre: " + buscado.getNombreCurso() + "\n";
            output += "Alumnos: " + buscado.getAlumnos() + "\n";
            output += "Evaluaciones: " + buscado.getEvaluacionCurso() + "\n";
            output += "Profesor: " + buscado.getProfesores() + "\n";
            return output;
        } else {
            return "No se ha encontrado el curso";
        }
    }

}
