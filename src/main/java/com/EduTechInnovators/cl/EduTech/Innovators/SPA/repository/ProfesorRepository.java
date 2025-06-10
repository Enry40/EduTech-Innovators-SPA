package com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
}
