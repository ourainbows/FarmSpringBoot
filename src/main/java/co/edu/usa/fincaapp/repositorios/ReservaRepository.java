package co.edu.usa.fincaapp.repositorios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Cliente;
import co.edu.usa.fincaapp.entidades.Reserva;
import co.edu.usa.fincaapp.reportes.ContadorClientes;

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

    public List<Reserva> getReservaByStatus(String status) {
        return reservaRepositorio.findAllByStatus(status);
    }

    public List<Reserva> getReservaPeriod(Date firstDate, Date secondDate) {
        return reservaRepositorio.findAllByStartDateAfterAndStartDateBefore(firstDate, secondDate);
    }

    public List<ContadorClientes> getTopClients() {
        List<ContadorClientes> res = new ArrayList<>();
        List<Object[]> report = reservaRepositorio.countTotalReservationByClient();
        for (int i = 0; i < report.size(); i++) {
            res.add(new ContadorClientes((Long) report.get(i)[1], (Cliente) report.get(i)[0]));
        }
        return res;
    }
}
