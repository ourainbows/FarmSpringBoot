package co.edu.usa.fincaapp.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Cliente;

/**
 * Creamos el CRUD
 */
@Repository
public class ClienteRepository {
    @Autowired
    private ClienteCrudRepository clienteRespositorio;

    /**
     * GET
     * @return
     */
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteRespositorio.findAll();
    }
    
    /**
     * GET BY ID
     * @param id
     * @return
     */
    public Optional<Cliente> getClientePorId(Long id) {
        return clienteRespositorio.findById(id);
    }
    
    /**
     * CREATE - UPDATE
     * @param cliente
     * @return
     */
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRespositorio.save(cliente);
    }
    
    /**
     * DELETE
     * @param cliente
     */
    public void borrarCliente(Cliente cliente){
        clienteRespositorio.delete(cliente);
    }
    /*public void borrarPorIdCliente(Long id){
        clienteRespositorio.deleteById(id);
    } */
}
