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
        // Comprobamos que no tengamos un objeto vacio
        if (mensaje != null) {
            // En caso de que nos hayan pasado un objeto sin id
            if (mensaje.getIdMessage() != null) {
                return mensajeRepositorio.guardarMensaje(mensaje);
            } else {
                // Consultamos si tenemos un objeto con ese id en la base de datos
                Optional<Mensaje> oMensaje = mensajeRepositorio.getMensajePorId(mensaje.getIdMessage());
                // Si no existe un objeto con ese id lo guardamos
                if (oMensaje.isEmpty()) {
                    return mensajeRepositorio.guardarMensaje(mensaje);
                    // Objeto existente en la base de datos
                } else {
                    return mensaje;
                }
            }
        }
        // Objeto vacio
        return mensaje;
    }

    public Mensaje updateMessage(Mensaje mensaje) {
        // Comprobamos que nuestro objeto lleve un id
        if (mensaje.getIdMessage() != null) {
            Optional<Mensaje> oMensaje = mensajeRepositorio.getMensajePorId(mensaje.getIdMessage());
            // Comprobamos que nuestro objeto exista en la base de datos para poder
            // actualizarlo
            if (!oMensaje.isEmpty()) {
                // Comprobamos cada atributo para saber si es vacio, en caso de no serlo lo
                // actualizamos
                if (mensaje.getMessageText() != null) {
                    oMensaje.get().setMessageText(mensaje.getMessageText());
                }
                // Actualizamos la informacion
                mensajeRepositorio.guardarMensaje(oMensaje.get());
                return oMensaje.get();
            } else {
                return mensaje;
            }
        } else {
            return mensaje;
        }
    }

    public boolean deleteMessage(Long id) {
        Boolean borrado = getMessageById(id).map(message -> {
            mensajeRepositorio.borrarMensaje(message);
            return true;
        }).orElse(false);
        return borrado;
    }
}