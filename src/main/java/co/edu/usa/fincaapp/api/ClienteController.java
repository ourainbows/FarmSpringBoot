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

@RestController
@RequestMapping("api/Client")
public class ClienteController {
    @Autowired private ClienteServicio clienteServicio;
    
    @GetMapping("/all")
    public List<Cliente> getCliente() {
        return clienteServicio.getClients();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> getClienteId(@PathVariable("id") Long clienteId) {
        return clienteServicio.getClientsById(clienteId);
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Cliente saveCliente(@RequestBody Cliente cliente) {
        return clienteServicio.saveClient(cliente);
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Cliente updateCliente(@RequestBody Cliente cliente) {
        return clienteServicio.updateClient(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public boolean deleteCliente(@PathVariable("id") Long categoriaId) {
        return clienteServicio.deleteClient(categoriaId);
    }
}
