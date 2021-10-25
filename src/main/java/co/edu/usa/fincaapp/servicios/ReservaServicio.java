package co.edu.usa.fincaapp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.fincaapp.entidades.Reserva;
import co.edu.usa.fincaapp.repositorios.ReservaRepository;

/**
 * En esta clase creamos el servicio para el modelo reserva
 */
@Service
public class ReservaServicio {// Esta clase sera una entidad
    @Autowired
    /**
     * Objeto de tipo repositorio que contiene todo el CRUD 
     */
    private ReservaRepository reservaRepositorio;

    /**
     * Get de todos los elementos del JSON de reservaciones
     * @return Un objeto de tipo JSON con todos sus elementos
     * @author Juan Casas
     */
    public List<Reserva> getAllReservation() {
        return reservaRepositorio.getReservas();
    }

    /**
     * Objetenemos un elemento a partir de su id
     * @param id -> el id del elemento que queremos consultar
     * @return Un JSON donde tenemos el elemento consultado por su id
     */
    public Optional<Reserva> getReservationById(Long id) {
        return reservaRepositorio.getReservaPorId(id);
    }

    /**
     * Guardamos el objeto de tipo reserva, teniendo en cuenta que el objeto
     * no este vacio y que no exista en nuestra base de datos
     * @param reserva -> el objeto de tipo reserva que va a ser guardado
     * @return podemos tener el objeto de vuelta en caso de no cumplir los requisitos o tambien podemos obtener el guardado del objeto
     * @author Juan Casas
     */
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

/**
 * Actualizamos la reserva teniendo en cuenta de que esta exista en nuestra base de datos 
 * @param reserva -> sera el objeto de tipo reserva, como minimo debe tener su id y un parametro a modificar
 * @return nos retorna el objeto si no cumplio con las condiciones o el actualizado del objeto
 * @author Juan Casas
 */
    public Reserva updateReservation(Reserva reserva) {
        // Comprobamos que nuestro objeto lleve un id
        if (reserva.getIdReservation() != null) {
            Optional<Reserva> oReserva = reservaRepositorio.getReservaPorId(reserva.getIdReservation());
            // Comprobamos que nuestro objeto exista en la base de datos para poder actualizarlo
            if (!oReserva.isEmpty()) {
                // Comprobamos cada atributo para saber si es vacio, en caso de no serlo lo actualizamos
                if (reserva.getStartDate() != null) {
                    oReserva.get().setStartDate(reserva.getStartDate());
                }
                if (reserva.getDevolutionDate() != null) {
                    oReserva.get().setDevolutionDate(reserva.getDevolutionDate());
                }
                if (reserva.getScore() != null) {
                    oReserva.get().setScore(reserva.getScore());
                }
                if (reserva.getStatus() != null) {
                    oReserva.get().setStatus(reserva.getStatus());
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

    /**
     * Borramos un objeto a partir de su id
     * @param id -> el id del objeto que deseamos borrar 
     * @return un booleano, true: el objeto fue borrado, false: el objeto NO fue borrado
     */
    public boolean deleteReservation(Long id) {
        Boolean borrado = getReservationById(id).map(reservation -> {
            reservaRepositorio.borrarReserva(reservation);
            return true;
        }).orElse(false);
        return borrado;
    }
}
