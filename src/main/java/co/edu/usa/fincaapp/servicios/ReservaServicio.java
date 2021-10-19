package co.edu.usa.fincaapp.servicios;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.fincaapp.entidades.Reserva;
import co.edu.usa.fincaapp.repositorios.ReservaRepository;

@Service
public class ReservaServicio {
    @Autowired
    private ReservaRepository reservaRepositorio;

    public List<Reserva> getAllReservation() {
        return reservaRepositorio.getReservas();
    }

    public Optional<Reserva> getReservationById(Long id) {
        return reservaRepositorio.getReservaPorId(id);
    }

    public Reserva saveReservation(Reserva reserva) {
        if (reserva != null) {
/*              SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
             Date fechaStart = formato.parse(reserva.getStartDate());
             String parseFecha = fechaStart + "";
             reserva.setStartDate(parseFecha); */
             
            if (reserva.getId() != null) {
                Optional<Reserva> oReserva = reservaRepositorio.getReservaPorId(reserva.getId());
                if (oReserva.isEmpty()) {
                    return reservaRepositorio.guardarReserva(reserva);
                } else {
                    return reserva;
                }
            } else {
                return reservaRepositorio.guardarReserva(reserva);
            }
        }
        return null;
    }
}
