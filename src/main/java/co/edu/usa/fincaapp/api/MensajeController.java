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

@RestController
@RequestMapping("api/Message")
@CrossOrigin(origins = "*")

public class MensajeController {
    @Autowired
    private MensajeServicio mensajeServicio;

    @GetMapping("/all")
    public List<Mensaje> getMensaje() {
        return mensajeServicio.getMessages();
    }

    @GetMapping("/{id}")
    public Optional<Mensaje> getMensajeId(@PathVariable("id") Long mensajeId) {
        return mensajeServicio.getMessageById(mensajeId);
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mensaje saveMensaje(@RequestBody Mensaje mensaje) {
        return mensajeServicio.saveMessage(mensaje);
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mensaje updateMensaje(@RequestBody Mensaje mensaje) {
        return mensajeServicio.updateMessage(mensaje);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public boolean deleteMensaje(@PathVariable("id") Long mensajeId){
        return mensajeServicio.deleteMessage(mensajeId);
    }

}
