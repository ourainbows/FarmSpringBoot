package co.edu.usa.fincaapp.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Administrador;

/**
 * Creamos un CRUD
 */
@Repository
public class AdministradorRepository {
    @Autowired
    private AdministradorCrudRespository administradorRepositorio;
    
    /**
     * GET
     * @return
     */
    public List<Administrador> getAdministradores() {
        return (List<Administrador>) administradorRepositorio.findAll();
    }

    /**
     * GET by id
     * @param id
     * @return
     */
    public Optional<Administrador> getAdministradorPorId(Long id) {
        return administradorRepositorio.findById(id);
    }

    /**
     * CREATE - UPDATE
     * @param administrador
     * @return
     */
    public Administrador guardarAdministrador(Administrador administrador) {
        return administradorRepositorio.save(administrador);
    }

    /**
     * DELETE
     * @param administrador
     */
    public void borrarAdministrador(Administrador administrador) {
        administradorRepositorio.delete(administrador);
    }
    
}
