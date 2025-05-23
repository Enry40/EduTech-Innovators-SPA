package com.EduTechInnovators.cl.EduTech.Innovators.SPA.service;


import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Curso;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Evaluacion;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.CursoRepository;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.EstudianteRepository;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.EvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    public String addCurso(Curso curso) {
        cursoRepository.save(curso);
        return  "Curso inscrito";
    }

    public String getAllCursos() {
        String output = "";
        for (Curso curso : cursoRepository.findAll()) {
            output += "ID Curso: " + curso.getIdCurso();
            output += "Nombre: " + curso.getNombreCurso();
            output += "Descripcion Curso: " + curso.getDescripcionCurso();
        } if (output.isEmpty()){
            return "Curso no encontrado";
        } else {
            return output;
        }
    }

    public String getAllEvaluaciones() {
        String output = "";
        for (Evaluacion evaluacion : evaluacionRepository.findAll()) {
            output += "Curso: " + evaluacion.getCurso().getIdCurso();
            output += "Nombre: " + evaluacion.getCurso().getNombreCurso();
            output += "ID Evaluacion: " + evaluacion.getIdEvaluacion();
            output += "Nota Evaluacion: " + evaluacion.getNotaEvaluacion();
        } if (output.isEmpty()){
            return "Evaluacion no encontrada";
        } else {
            return output;
        }
    }


}
