package com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Integer>{
}
