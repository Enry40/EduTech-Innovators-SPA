package com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface administradorRepository  extends JpaRepository<administrador, Integer> {
}
