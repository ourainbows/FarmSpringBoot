package co.edu.usa.fincaapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usa.fincaapp.entidades.Administrador;
import co.edu.usa.fincaapp.servicios.AdministradorServicio;

@RestController
@RequestMapping("api/Admin")
@CrossOrigin(origins = "*")
public class AdministradorController {
    @Autowired private AdministradorServicio administradorServicio;
    
    @GetMapping("/all")
    public List<Administrador> getAdmin() {
        return administradorServicio.getAdmins();
    }

    @PostMapping("/save")
    public Administrador saveAdmin(@RequestBody Administrador administrador) {
        return administradorServicio.saveAdmnin(administrador);
    }


}
