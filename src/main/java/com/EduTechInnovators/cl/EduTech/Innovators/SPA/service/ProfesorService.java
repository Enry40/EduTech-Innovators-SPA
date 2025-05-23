package com.EduTechInnovators.cl.EduTech.Innovators.SPA.service;


import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

}
