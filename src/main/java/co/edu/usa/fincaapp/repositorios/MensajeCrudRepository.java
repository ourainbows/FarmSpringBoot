package co.edu.usa.fincaapp.repositorios;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.fincaapp.entidades.Mensaje;

public interface MensajeCrudRepository extends CrudRepository <Mensaje,Long> {
    
}
