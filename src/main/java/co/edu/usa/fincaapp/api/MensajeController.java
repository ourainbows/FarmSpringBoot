package co.edu.usa.fincaapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usa.fincaapp.entidades.Mensaje;
import co.edu.usa.fincaapp.servicios.MensajeServicio;

@RestController
@RequestMapping("api/Message")
@CrossOrigin(origins = "*")

public class MensajeController {
    @Autowired private MensajeServicio mensajeServicio;
    
    @GetMapping("/all")
    public List<Mensaje> getMensaje() {
        return mensajeServicio.getMessages();
    }

    @PostMapping("/save")
    public Mensaje saveMensaje(@RequestBody Mensaje mensaje) {
        return mensajeServicio.saveMessage(mensaje);
    }


}
