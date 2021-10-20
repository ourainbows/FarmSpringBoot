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

import co.edu.usa.fincaapp.entidades.Reserva;
import co.edu.usa.fincaapp.servicios.ReservaServicio;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*")

public class ReservaController {
    @Autowired private ReservaServicio reservaServicio;
    
    @GetMapping("/all")
    public List<Reserva> getReserva() {
        return reservaServicio.getAllReservation();
    }
    
    @GetMapping("/{id}")
    public Optional<Reserva> getReservaId(@PathVariable("id") Long reservaId) {
        return reservaServicio.getReservationById(reservaId);
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    //@ResponseStatus(HttpStatus.CREATED)
    public Reserva saveReserva(@RequestBody Reserva reserva) {
        return reservaServicio.saveReservation(reserva);
    }
    
    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Reserva updateReserva(@RequestBody Reserva reserva) {
        return reservaServicio.updateReservation(reserva);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public boolean deleteReserva(@PathVariable("id") Long reservaId) {
        return reservaServicio.deleteReservation(reservaId);
    }
}
