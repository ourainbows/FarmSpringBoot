package co.edu.usa.fincaapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    public Reserva saveReserva(@RequestBody Reserva reserva) {
        return reservaServicio.saveReservation(reserva);
    }
    
}
