package com.EduTechInnovators.cl.EduTech.Innovators.SPA.service;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.administrador;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.repository.administradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class administradorService {

    @Autowired
    private administradorRepository administradorRepository;

    public  String addAdministrador(administrador administrador){
        administradorRepository.save(administrador);
        return "User Added Successfully";
    }

    public String deleteAdministrador(int id){
        if (administradorRepository.existsById(id)){
            administradorRepository.deleteById(id);
            return "User Deleted Successfully";
        }
        else {
            return "User Not Found";
        }
    }

    public String updateAdministrador(int id, administrador administrador){
        if (administradorRepository.existsById(id)){
            administrador buscado = administradorRepository.findById(id).get();
            buscado.setName(administrador.getName());
            buscado.setPassword(administrador.getPassword());
            buscado.setEmail(administrador.getEmail());
            buscado.setUserType(administrador.getUserType());
            return "User Updated Successfully";
        }
        else {
            return "User Not Found";
        }
    }

    public String getUserById(int id) {
        String output = "";
        if (administradorRepository.existsById(id)) {
            administrador administrador = administradorRepository.findById(id).get();
            output+="ID administrador: " +administrador.getId_user() + "\n";
            output += "Name: " +administrador.getName() + "\n";
            output += "Password: " +administrador.getPassword() + "\n";
            output += "Email: " +administrador.getEmail() + "\n";
            output += "Tipo Usuario: " +administrador.getUserType() + "\n";
            return output;
        }
        else {
            return "User not found";
        }
    }

    public String getAllAdministrador() {
        String output = "";
        for (administrador administrador : administradorRepository.findAll()) {
            output += "ID administrador: " +administrador.getId_user() + "\n";
            output += "Name: " +administrador.getName() + "\n";
            output += "Password: " +administrador.getPassword() + "\n";
            output += "Email: " +administrador.getEmail() + "\n";
            output += "Tipo Usuario: " +administrador.getUserType() + "\n";
        }
        if (output.isEmpty()){
            return "User not found";
        }
        else {
            return output;
        }
    }

}
