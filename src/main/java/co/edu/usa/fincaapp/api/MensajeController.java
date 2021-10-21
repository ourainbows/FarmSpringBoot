package co.edu.usa.fincaapp.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usa.fincaapp.entidades.Mensaje;
import co.edu.usa.fincaapp.servicios.MensajeServicio;


/**
 * Controlador de mensajes
 */
@RestController
@RequestMapping("api/Message")
@CrossOrigin(origins = "*")
public class MensajeController {
    @Autowired
    // Servicio de menajes
    private MensajeServicio mensajeServicio;

    /**
     * Obtenemos todos los mensajes 
     * @return los mensajes
     */
    @GetMapping("/all")
    public List<Mensaje> getMensaje() {
        return mensajeServicio.getMessages();
    }

    /**
     * Obtenemos un mensaje por su id
     * @param mensajeId -> el id que tenga nuestro mensaje a consultar
     * @return el texto del mensaje consultado
     */
    @GetMapping("/{id}")
    public Optional<Mensaje> getMensajeId(@PathVariable("id") Long mensajeId) {
        return mensajeServicio.getMessageById(mensajeId);
    }

    /**
     * Creamos un nuevo mensaje
     * @param mensaje -> los datos del nuevo mensaje
     * @return un mensaje nuevo
     */
    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mensaje saveMensaje(@RequestBody Mensaje mensaje) {
        return mensajeServicio.saveMessage(mensaje);
    }

    /**
     * Actualizamos un mensaje existente
     * @param mensaje -> el id del mensaje y los nuevos datos
     * @return el mensaje actualizado
     */
    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mensaje updateMensaje(@RequestBody Mensaje mensaje) {
        return mensajeServicio.updateMessage(mensaje);
    }

    /**
     * Borramos un mensaje a partir de su id
     * @param mensajeId -> el id del mensaje que vamos a borrar
     * @return el mensaje borrado
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public boolean deleteMensaje(@PathVariable("id") Long mensajeId){
        return mensajeServicio.deleteMessage(mensajeId);
    }

}
