package co.edu.usa.fincaapp.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.usa.fincaapp.entidades.Reserva;

public interface ReservaCrudRepository extends CrudRepository <Reserva, Long>  {
    
    public List<Reserva> findAllByStatus(String status);

    public List<Reserva> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    // select clientid, count(*) as "total" from reservacion group by clientid order
    // by total desc;
    @Query("SELECT c.client, COUNT(c.client) FROM Reserva AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationByClient();
}
