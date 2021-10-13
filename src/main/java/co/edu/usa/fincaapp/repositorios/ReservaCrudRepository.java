package co.edu.usa.fincaapp.repositorios;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.fincaapp.entidades.Reserva;

public interface ReservaCrudRepository extends CrudRepository <Reserva, Long>  {
    
}
