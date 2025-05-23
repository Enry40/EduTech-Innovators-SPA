package com.EduTechInnovators.cl.EduTech.Innovators.SPA.service;


import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.EvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluacionService {

    @Autowired
    EvaluacionRepository evaluacionRepository;

}
