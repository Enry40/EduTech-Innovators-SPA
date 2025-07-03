package com.EduTechInnovators.cl.EduTech.Innovators.SPA.assembler;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.controller.AlumnoController;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Alumno;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class AlumnoModelAssembler implements RepresentationModelAssembler<Alumno, EntityModel<Alumno>> {

    @Override
    public EntityModel<Alumno> toModel(Alumno alumno) {
        return EntityModel.of(alumno,
                linkTo(methodOn(AlumnoController.class).getAllCursos()).withRel("Cursos"),
                 linkTo(methodOn(AlumnoController.class).updateAlumno(alumno.getId(), alumno)).withRel("update-Alumno")
        );
    }
}
