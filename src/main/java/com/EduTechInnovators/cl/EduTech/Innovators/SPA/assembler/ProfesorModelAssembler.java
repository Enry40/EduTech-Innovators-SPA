package com.EduTechInnovators.cl.EduTech.Innovators.SPA.assembler;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.controller.ProfesorController;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Profesor;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.service.CursoService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ProfesorModelAssembler implements RepresentationModelAssembler <Profesor, EntityModel<Profesor>> {
    private final CursoService cursoService;

    public ProfesorModelAssembler(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @Override
    public EntityModel<Profesor> toModel(Profesor profesor) {
        return EntityModel.of(profesor,
                linkTo(methodOn(ProfesorController.class).updateProfesorPro(profesor.getId(), profesor)).withRel("update-profesor"),
                linkTo(methodOn(ProfesorController.class).getAllCursos()).withRel("Cursos")
        );
    }
}
