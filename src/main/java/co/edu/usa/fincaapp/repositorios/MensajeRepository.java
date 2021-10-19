package co.edu.usa.fincaapp.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Mensaje;

@Repository
public class MensajeRepository {
    @Autowired
    private MensajeCrudRepository mensajeRepositorio;

    public List<Mensaje> getMensaje() {
        return (List<Mensaje>)mensajeRepositorio.findAll();
    }

    public Optional<Mensaje> getMensajePorId(Long id) {
        return mensajeRepositorio.findById(id);
    }

    public Mensaje guardarMensaje(Mensaje mensaje) {
        return mensajeRepositorio.save(mensaje);
    }

    public void borrarMensaje(Mensaje mensaje) {
        mensajeRepositorio.delete(mensaje);
    }
}
