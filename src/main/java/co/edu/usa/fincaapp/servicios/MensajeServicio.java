package co.edu.usa.fincaapp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.fincaapp.entidades.Mensaje;
import co.edu.usa.fincaapp.repositorios.MensajeRepository;

@Service
public class MensajeServicio {
    @Autowired
    private MensajeRepository mensajeRepositorio;

    public List<Mensaje> getMessages() {
        return mensajeRepositorio.getMensaje();
    }

    public Optional<Mensaje> getMessageById(Long id) {
        return mensajeRepositorio.getMensajePorId(id);
    }

    public Mensaje saveMessage(Mensaje mensaje) {
        if (mensaje != null) {
            if (mensaje.getIdMessage() != null) {
                Optional<Mensaje> oMessage = mensajeRepositorio.getMensajePorId(mensaje.getIdMessage());
                if (oMessage.isEmpty()) {
                    return mensajeRepositorio.guardarMensaje(mensaje);
                } else {
                    return mensaje;
                }
            } else {
                return mensajeRepositorio.guardarMensaje(mensaje);
            }
        }
        return null;
    }
}