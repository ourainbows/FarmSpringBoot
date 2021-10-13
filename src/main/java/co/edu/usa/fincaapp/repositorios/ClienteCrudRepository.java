package co.edu.usa.fincaapp.repositorios;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.fincaapp.entidades.Cliente;

public interface ClienteCrudRepository extends CrudRepository<Cliente, Long>{
    
}
