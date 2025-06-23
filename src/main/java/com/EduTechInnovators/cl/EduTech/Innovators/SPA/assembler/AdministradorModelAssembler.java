package com.EduTechInnovators.cl.EduTech.Innovators.SPA.assembler;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.controller.AdministradorController;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.controller.AlumnoController;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Administrador;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Alumno;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Curso;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Profesor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class AdministradorModelAssembler implements RepresentationModelAssembler<Administrador, EntityModel<Administrador>> {

    @Override
    public EntityModel<Administrador> toModel(Administrador administrador) {
        return EntityModel.of(administrador,
                linkTo(methodOn(AdministradorController.class).getAdminById(administrador.getId())).withSelfRel(),
                linkTo(methodOn(AdministradorController.class).getAllAdmin()).withRel("administradores"),
                linkTo(methodOn(AdministradorController.class).addAdmin(administrador)).withRel("add-administrador"),
                linkTo(methodOn(AdministradorController.class).updateAdmin(administrador.getId(), administrador)).withRel("update-administrador"),
                linkTo(methodOn(AdministradorController.class).deleteAdmin(administrador.getId())).withRel("delete-administrador"),

                linkTo(methodOn(AdministradorController.class).addAlumno(new Alumno())).withRel("add-alumno"),
                linkTo(methodOn(AdministradorController.class).getAllAlumnos()).withRel("alumnos"),
                linkTo(methodOn(AdministradorController.class).getAlumnoById(1)).withRel("get-alumno-by-id"),
                linkTo(methodOn(AdministradorController.class).updateAlumno(1, new Alumno())).withRel("update-alumno"),
                linkTo(methodOn(AdministradorController.class).deleteAlumno(1)).withRel("delete-alumno"),

                linkTo(methodOn(AdministradorController.class).addProfesor(new Profesor())).withRel("add-profesor"),
                linkTo(methodOn(AdministradorController.class).getAllProfesores()).withRel("profesores"),
                linkTo(methodOn(AdministradorController.class).getProfesorById(1)).withRel("get-profesor-by-id"),
                linkTo(methodOn(AdministradorController.class).updateProfesor(1, new Profesor())).withRel("update-profesor"),
                linkTo(methodOn(AdministradorController.class).deleteProfesor(1)).withRel("delete-profesor"),

                linkTo(methodOn(AdministradorController.class).addCurso(new Curso())).withRel("add-curso"),
                linkTo(methodOn(AdministradorController.class).getAllCursos()).withRel("cursos"),
                linkTo(methodOn(AdministradorController.class).getCursoById(1)).withRel("get-curso-by-id"),
                linkTo(methodOn(AdministradorController.class).updateCursoAdmin(1, new Curso())).withRel("update-curso"),
                linkTo(methodOn(AdministradorController.class).deleteCurso(1)).withRel("delete-curso"),
                linkTo(methodOn(AdministradorController.class).addAlumnoCurso(1, 1)).withRel("add-alumno-curso"),
                linkTo(methodOn(AdministradorController.class).addProfesorCurso(1, 1)).withRel("add-profesor-curso")

        );

    }
}
