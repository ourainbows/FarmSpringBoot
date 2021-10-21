package co.edu.usa.fincaapp.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Mensaje;

/**
 * Creamos un CRUD
 */
@Repository
public class MensajeRepository {
    @Autowired
    private MensajeCrudRepository mensajeRepositorio;

    /**
     * GET
     * @return
     */
    public List<Mensaje> getMensaje() {
        return (List<Mensaje>)mensajeRepositorio.findAll();
    }

    /**
     * GET BY ID
     * @param id
     * @return
     */
    public Optional<Mensaje> getMensajePorId(Long id) {
        return mensajeRepositorio.findById(id);
    }

    /**
     * CREATE - UPDATE
     * @param mensaje
     * @return
     */
    public Mensaje guardarMensaje(Mensaje mensaje) {
        return mensajeRepositorio.save(mensaje);
    }

    /**
     * DELETE
     * @param mensaje
     */
    public void borrarMensaje(Mensaje mensaje) {
        mensajeRepositorio.delete(mensaje);
    }
}
