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
import co.edu.usa.fincaapp.reportes.ContadorClientes;
import co.edu.usa.fincaapp.reportes.StatusReservas;
import co.edu.usa.fincaapp.servicios.ReservaServicio;

/**
 * Controlador de la reserva
 */
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*")
public class ReservaController {
    // Servicio de la reserva
    @Autowired private ReservaServicio reservaServicio;
    
    /**
     * Obtenemos las reservas 
     * @return las reservas y sus datos
     */
    @GetMapping("/all")
    public List<Reserva> getReserva() {
        return reservaServicio.getAllReservation();
    }
    
    /**
     * Obtenemos una reservacion a partir de su id
     * @param reservaId -> el id de la reserva a consultar
     * @return la reserva y todos sus datos
     */
    @GetMapping("/{id}")
    public Optional<Reserva> getReservaId(@PathVariable("id") Long reservaId) {
        return reservaServicio.getReservationById(reservaId);
    }

    /**
     * Creamos una nueva reservacion
     * @param reserva -> los datos de la nueva reservacion
     * @return la reserva creada
     */
    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    //@ResponseStatus(HttpStatus.CREATED)
    public Reserva saveReserva(@RequestBody Reserva reserva) {
        return reservaServicio.saveReservation(reserva);
    }
    
    /**
     * Actualizamos una reserva
     * @param reserva -> el id de la reserva y los datos que vamos a actualizar
     * @return la reserva actualizada
     */
    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Reserva updateReserva(@RequestBody Reserva reserva) {
        return reservaServicio.updateReservation(reserva);
    }

    /**
     * Borramos una reserva mediante su id
     * @param reservaId -> el id de la reserva quer vamos a borrar
     * @return la reserva borrada
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public boolean deleteReserva(@PathVariable("id") Long reservaId) {
        return reservaServicio.deleteReservation(reservaId);
    }

    @GetMapping("/report-status")
    public StatusReservas getReservationStatusReport() {
        return reservaServicio.getReservationStatusReport();
    }
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reserva> getReservationsReportDates(@PathVariable("dateOne") String dateOne,
            @PathVariable("dateTwo") String dateTwo) {
        return reservaServicio.getReservationPeriod(dateOne, dateTwo);
    }
    @GetMapping("/report-clients")
    public List<ContadorClientes> getReservationsReportClient() {
        return reservaServicio.getTopClients();
    }
}
