package co.edu.usa.fincaapp.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Reserva;

@Repository
public class ReservaRepository {
    @Autowired
    private ReservaCrudRepository reservaRepositorio;

    public List<Reserva> getReservas() {
        return (List<Reserva>) reservaRepositorio.findAll();
    }

    public Optional<Reserva> getReservaPorId(Long id) {
        return reservaRepositorio.findById(id);
    }

    public Reserva guardarReserva(Reserva reserva) {
        return reservaRepositorio.save(reserva);
    }

    public void borrarReserva(Reserva reserva) {
        reservaRepositorio.delete(reserva);
    }
}
