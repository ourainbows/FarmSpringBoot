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

    public Optional<Administrador> getAdminById(Long id) {
        return administradorRepositorio.getAdministradorPorId(id);
    }

    public Administrador saveAdmnin(Administrador administrador) {
        // Comprobamos que no tengamos un objeto vacio
        if (administrador != null) {
            // En caso de que nos hayan pasado un objeto sin id
            if (administrador.getId() == null) {
                return administradorRepositorio.guardarAdministrador(administrador);
            } else {
                // Consultamos si tenemos un objeto con ese id en la base de datos
                Optional<Administrador> oAdmin = administradorRepositorio.getAdministradorPorId(administrador.getId());
                // Si no existe un objeto con ese id lo guardamos
                if (oAdmin.isEmpty()) {
                    return administradorRepositorio.guardarAdministrador(administrador);
                // Objeto existente en la base de datos
                } else {
                    return administrador;
                }
            }
        }
        // Objeto vacio
        return administrador;
    }

    public Administrador updateAdmin(Administrador administrador) {
        // Comprobamos que nuestro objeto lleve un id
        if (administrador.getId() != null) {
            Optional<Administrador> oAdmin = administradorRepositorio.getAdministradorPorId(administrador.getId());
            // Comprobamos que nuestro objeto exista en la base de datos para poder actualizarlo
            if (!oAdmin.isEmpty()) {
                // Comprobamos cada atributo para saber si es vacio, en caso de no serlo lo actualizamos
                if (administrador.getName() != null) {
                    oAdmin.get().setName(administrador.getName());
                }
                if (administrador.getEmail() != null) {
                    oAdmin.get().setEmail(administrador.getEmail());
                }
                if (administrador.getPassword() != null) {
                    oAdmin.get().setPassword(administrador.getPassword());
                }
                //Actualizamos la informacion
                administradorRepositorio.guardarAdministrador(oAdmin.get());
                return oAdmin.get();
            } else {
                return administrador;
            }
        } else {
            return administrador;
        }
    }
    
    public boolean deleteAdmin(Long id) {
        Boolean borrado = getAdminById(id).map(admin ->{
            administradorRepositorio.borrarAdministrador(admin);
            return true;
        }).orElse(false);
        return borrado;
    }

}