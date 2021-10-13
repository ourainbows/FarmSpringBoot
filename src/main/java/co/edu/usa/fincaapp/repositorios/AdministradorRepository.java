package co.edu.usa.fincaapp.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Administrador;

@Repository
public class AdministradorRepository {
    @Autowired
    private AdministradorCrudRespository administradorRepositorio;
    
    public List<Administrador> getAdministradores() {
        return (List<Administrador>) administradorRepositorio.findAll();
    }

    public Optional<Administrador> getAdministradorPorId(Long id) {
        return administradorRepositorio.findById(id);
    }

    public Administrador guardarAdministrador(Administrador administrador) {
        return administradorRepositorio.save(administrador);
    }
}
