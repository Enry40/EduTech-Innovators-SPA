package com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
