package co.edu.usa.fincaapp.servicios;

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
        // Comprobamos que no tengamos un objeto vacio
        if (reserva != null) {
            // En caso de que nos hayan pasado un objeto sin id
            if (reserva.getIdReservation() == null) {
                return reservaRepositorio.guardarReserva(reserva);
            } else {
                // Consultamos si tenemos un objeto con ese id en la base de datos
                Optional<Reserva> oReserva = reservaRepositorio.getReservaPorId(reserva.getIdReservation());
                // Si no existe un objeto con ese id lo guardamos
                if (oReserva.isEmpty()) {
                    return reservaRepositorio.guardarReserva(reserva);
                    // Objeto existente en la base de datos
                } else {
                    return reserva;
                }
            }
        }
        // Objeto vacio
        return reserva;
    }

    public Reserva updateReservation(Reserva reserva) {
        // Comprobamos que nuestro objeto lleve un id
        if (reserva.getIdReservation() != null) {
            Optional<Reserva> oReserva = reservaRepositorio.getReservaPorId(reserva.getIdReservation());
            // Comprobamos que nuestro objeto exista en la base de datos para poder
            // actualizarlo
            if (!oReserva.isEmpty()) {
                // Comprobamos cada atributo para saber si es vacio, en caso de no serlo lo
                // actualizamos
                if (reserva.getStartDate() != null) {
                    oReserva.get().setStartDate(reserva.getStartDate());
                }
                if (reserva.getDevolutionDate() != null) {
                    oReserva.get().setDevolutionDate(reserva.getDevolutionDate());
                }
                // Actualizamos la informacion
                reservaRepositorio.guardarReserva(oReserva.get());
                return oReserva.get();
            } else {
                return reserva;
            }
        } else {
            return reserva;
        }
    }

    public boolean deleteReservation(Long id) {
        Boolean borrado = getReservationById(id).map(reservation -> {
            reservaRepositorio.borrarReserva(reservation);
            return true;
        }).orElse(false);
        return borrado;
    }
}
