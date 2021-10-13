package co.edu.usa.fincaapp.repositorios;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.fincaapp.entidades.Administrador;

public interface AdministradorCrudRespository extends CrudRepository<Administrador, Long> {
    
}
