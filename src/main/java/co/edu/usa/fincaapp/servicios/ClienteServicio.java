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
    private ClienteRepository clienteRepositorio;

    public List<Cliente> getClients() {
        return clienteRepositorio.getClientes();
    }
    
    public Optional<Cliente> getClientsById(Long id) {
        return clienteRepositorio.getClientePorId(id);
    }
    
    public Cliente saveClient(Cliente cliente) {
        // Comprobamos que no tengamos un objeto vacio
        if (cliente != null) {
            // En caso de que nos hayan pasado un objeto sin id
            if (cliente.getIdClient() == null) {
                return clienteRepositorio.guardarCliente(cliente);
            } else {
                // Consultamos si tenemos un objeto con ese id en la base de datos
                Optional<Cliente> oCliente = clienteRepositorio.getClientePorId(cliente.getIdClient());
                // Si no existe un objeto con ese id lo guardamos
                if (oCliente.isEmpty()) {
                    return clienteRepositorio.guardarCliente(cliente);
                    // Objeto existente en la base de datos
                } else {
                    return cliente;
                }
            }
        }
        // Objeto vacio
        return cliente;
    }
    
    public Cliente updateClient(Cliente cliente) {
        // Comprobamos que nuestro objeto lleve un id
        if (cliente.getIdClient() != null) {
            Optional<Cliente> oCliente = clienteRepositorio.getClientePorId(cliente.getIdClient());
            // Comprobamos que nuestro objeto exista en la base de datos para poder
            // actualizarlo
            if (!oCliente.isEmpty()) {
                // Comprobamos cada atributo para saber si es vacio, en caso de no serlo lo
                // actualizamos
                if (cliente.getName() != null) {
                    oCliente.get().setName(cliente.getName());
                }
                if (cliente.getEmail() != null) {
                    oCliente.get().setEmail(cliente.getEmail());
                }
                if (cliente.getPassword() != null) {
                    oCliente.get().setPassword(cliente.getPassword());
                }
                if (cliente.getAge() != null) {
                    oCliente.get().setAge(cliente.getAge());
                }
                // Actualizamos la informacion
                clienteRepositorio.guardarCliente(oCliente.get());
                return oCliente.get();
            } else {
                return cliente;
            }
        } else {
            return cliente;
        }
    }

    public boolean deleteClient(Long id) {
        Boolean borrado = getClientsById(id).map(cliente -> {
            clienteRepositorio.borrarCliente(cliente);
            return true;
        }).orElse(false);
        return borrado;
    }
}
