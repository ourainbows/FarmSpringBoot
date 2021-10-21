package co.edu.usa.fincaapp.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Reserva;

/**
 * Creamos el CRUD
 */
@Repository
public class ReservaRepository {
    @Autowired
    private ReservaCrudRepository reservaRepositorio;

    /**
     * GET
     * @return
     */
    public List<Reserva> getReservas() {
        return (List<Reserva>) reservaRepositorio.findAll();
    }

    /**
     * GET BY ID
     * @param id
     * @return
     */
    public Optional<Reserva> getReservaPorId(Long id) {
        return reservaRepositorio.findById(id);
    }

    /**
     * CREATE - UPDATE
     * @param reserva
     * @return
     */
    public Reserva guardarReserva(Reserva reserva) {
        return reservaRepositorio.save(reserva);
    }

    /**
     * DELETE
     * @param reserva
     */
    public void borrarReserva(Reserva reserva) {
        reservaRepositorio.delete(reserva);
    }
}
