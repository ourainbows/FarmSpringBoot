package co.edu.usa.fincaapp.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usa.fincaapp.entidades.Cliente;
import co.edu.usa.fincaapp.servicios.ClienteServicio;

/**
 * Clase del controlador del cliente
 */
@RestController
@RequestMapping("api/Client")
public class ClienteController {
    //llamada al servicio
    @Autowired private ClienteServicio clienteServicio;   

    /**
     * Obtenemos todos los clientes existentes
     * @return -> los clientes existente
     */
    @GetMapping("/all")
    public List<Cliente> getCliente() {
        return clienteServicio.getClients();
    }

    /**
     * Consultamos un cliente por su id
     * @param clienteId -> el id del cliente
     * @return .-> los datos completos del cliente
     */
    @GetMapping("/{id}")
    public Optional<Cliente> getClienteId(@PathVariable("id") Long clienteId) {
        return clienteServicio.getClientsById(clienteId);
    }

    /**
     * Guardamos un nuevo cliente
     * @param cliente -> los datos del nuevo cliente que queremos guardar
     * @return el cliente guardado
     */
    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Cliente saveCliente(@RequestBody Cliente cliente) {
        return clienteServicio.saveClient(cliente);
    }

    /**
     * Actualizamos un cliente 
     * @param cliente -> el id del cliente y los datos que vamos a actulizar
     * @return -> el cliente actulizado
     */
    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Cliente updateCliente(@RequestBody Cliente cliente) {
        return clienteServicio.updateClient(cliente);
    }

    /**
     * Borramos un cliente a partir de su id
     * @param categoriaId -> el id del cliente que vamos a eliminar
     * @return -> el cliente borrado
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public boolean deleteCliente(@PathVariable("id") Long categoriaId) {
        return clienteServicio.deleteClient(categoriaId);
    }
}
