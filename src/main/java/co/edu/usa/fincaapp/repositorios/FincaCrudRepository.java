package co.edu.usa.fincaapp.repositorios;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.fincaapp.entidades.Finca;

public interface FincaCrudRepository extends CrudRepository<Finca,Long>{
    
}
