package co.edu.usa.fincaapp.servicios;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.fincaapp.entidades.Cliente;
import co.edu.usa.fincaapp.repositorios.ClienteRepository;

@Service
public class ClienteServicio {
    @Autowired
    private ClienteRepository clienteRespositorio;

    public List<Cliente> obtenerTodoClientes(){
        return clienteRespositorio.getClientes();
    }
    public Optional<Cliente> getCliente(Long id){
        return clienteRespositorio.getClientePorId(id);
    }
    public Cliente guardar(Cliente cliente) {
        if(cliente != null){
            if(cliente.getId() != null){
                Optional<Cliente> oCliente = clienteRespositorio.getClientePorId(cliente.getId());
                if(oCliente.isEmpty()){
                    return clienteRespositorio.guardarCliente(cliente);
                }else{
                    return cliente;
                }
            }else{
                return clienteRespositorio.guardarCliente(cliente);
            }
        }
        return null;
    }  
/*     public Cliente actualizar(Cliente cliente) {
        if(cliente.getId() != null){
            Optional<Cliente> oCliente = clienteRespositorio.getClientePorId(cliente.getId());
            if(!oCliente.isEmpty()){
                Cliente c = oCliente.get();
                if(cliente.getName()!= null){
                    c.setName(cliente.getName());
                }
                if(cliente.getEmail()!= null){
                    c.setEmail(cliente.getEmail());
                }
                if(cliente.getAge() != null){
                    c.setAge(cliente.getAge());
                }
                if(cliente.getPassword()!= null){
                    c.setPassword(cliente.getPassword());
                }

                return clienteRespositorio.guardarCliente(c);
            }else{
                return cliente;
            }
        }else{
            return cliente;
        }
    }

    public boolean borrarCliente(Long id){
        Boolean borrado =  getCliente(id).map(c -> {
            clienteRespositorio.borrarCliente(c);
            return true;
        }).orElse(false);
        return borrado;
    
    } */
}
