package com.EduTechInnovators.cl.EduTech.Innovators.SPA.service;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Profesor;

public interface ProfesorService {
    public String addProfesor(Profesor profe);
    public String deleteProfesor(int id);
    public String updateProfesor(int id, Profesor profe);
    public String getProfesoresById(int id);
    public String getAllProfesores();
    public String updateProfesorPro(int id, Profesor profe);
}
