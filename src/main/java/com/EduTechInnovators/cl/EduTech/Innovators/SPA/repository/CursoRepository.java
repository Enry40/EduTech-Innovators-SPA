package com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
