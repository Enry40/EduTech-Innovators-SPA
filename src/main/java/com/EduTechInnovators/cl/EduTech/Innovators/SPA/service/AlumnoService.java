package com.EduTechInnovators.cl.EduTech.Innovators.SPA.service;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Alumno;

public interface AlumnoService {
    public String addAlumno(Alumno alu);
    public String getAllAlumnos();
    public String getAlumnoById(int id);
    public String updateAlumno(int id, Alumno alu);
    public String deleteAlumno(int id);
}
