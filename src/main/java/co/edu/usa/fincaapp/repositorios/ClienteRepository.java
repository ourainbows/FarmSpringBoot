package co.edu.usa.fincaapp.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Cliente;

@Repository
public class ClienteRepository {
    @Autowired
    private ClienteCrudRepository clienteRespositorio;

    public List<Cliente> getClientes(){
        return (List<Cliente>) clienteRespositorio.findAll();
    }
    public Optional<Cliente> getClientePorId(Long id){
        return clienteRespositorio.findById(id);
    }
    public Cliente guardarCliente(Cliente cliente){
        return clienteRespositorio.save(cliente);
    }
/*     public void borrarCliente(Cliente cliente){
        clienteRespositorio.delete(cliente);
    }
    public void borrarPorIdCliente(Long id){
        clienteRespositorio.deleteById(id);
    } */
}
