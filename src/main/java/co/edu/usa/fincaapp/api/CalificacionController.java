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

import co.edu.usa.fincaapp.entidades.Calificacion;
import co.edu.usa.fincaapp.servicios.CalificacionServicio;

/**
 * Clase del controlador de calificacion
 */
@RestController
@RequestMapping("api/Score")
@CrossOrigin(origins = "*")
public class CalificacionController {
    //lamada al servicio
    @Autowired
    private CalificacionServicio calificacionServicio;
    
    /**
     * Obtenemos las calificaciones existentes
     * @return -> calificaciones a las reservas
     */
    @GetMapping("/all")
    public List<Calificacion> getCalificacion() {
        return calificacionServicio.getScore();
    }
    /**
     * Guardamos una calificacion
     * @param calificacion -> calificacion reserva
     * @return calificacion guardada
     */
    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Calificacion saveCalificacion(@RequestBody Calificacion calificacion) {
        return calificacionServicio.saveScore(calificacion);
    }
    /**
     * Actualizamos una calificacion
     * @param calificacion -> calificacion a la reserva
     * @return calificacion actualizada
     */
    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Calificacion updateCalificacion(@RequestBody Calificacion calificacion) {
        return calificacionServicio.updateScore(calificacion);
    }
}
