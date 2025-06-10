package com.EduTechInnovators.cl.EduTech.Innovators.SPA.service;

import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Usuario;
import com.EduTechInnovators.cl.EduTech.Innovators.SPA.model.Administrador;

public interface AdministradorService {
    public String addAdmin(Administrador admin);
    public String getAllAdmin();
    public String getAdminById(int id);
    public String deleteAdmin(int id);
    public String updateAdmin(int id, Administrador admin);
}
