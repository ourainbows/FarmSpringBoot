package co.edu.usa.fincaapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usa.fincaapp.entidades.Cliente;
import co.edu.usa.fincaapp.servicios.ClienteServicio;

@RestController
@RequestMapping("api/Client")
public class ClienteController {
    @Autowired private ClienteServicio clienteServicio;
    
    @GetMapping("/all")
    public List<Cliente> getCliente() {
        return clienteServicio.obtenerTodoClientes();
    }
    @PostMapping("/save")
    public Cliente saveCliente(@RequestBody Cliente cliente) {
        return clienteServicio.guardar(cliente);
    }
}
