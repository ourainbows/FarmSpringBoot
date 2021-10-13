package co.edu.usa.fincaapp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.fincaapp.entidades.Administrador;
import co.edu.usa.fincaapp.repositorios.AdministradorRepository;

@Service
public class AdministradorServicio {
    @Autowired
    private AdministradorRepository administradorRepositorio;

    public List<Administrador> getAdmins() {
        return administradorRepositorio.getAdministradores();
    }

    public Optional<Administrador> getAdminiById(Long id) {
        return administradorRepositorio.getAdministradorPorId(id);
    }

    public Administrador saveAdmnin(Administrador administrador) {
        if (administrador != null) {
            if (administrador.getId() != null) {
                Optional<Administrador> oAdmin = administradorRepositorio.getAdministradorPorId(administrador.getId());
                if (oAdmin.isEmpty()) {
                    return administradorRepositorio.guardarAdministrador(administrador);
                } else {
                    return administrador;
                }
            } else {
                return administradorRepositorio.guardarAdministrador(administrador);
            }
        }
        return null;
    }

}