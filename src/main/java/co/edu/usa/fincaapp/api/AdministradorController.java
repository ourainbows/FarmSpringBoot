package co.edu.usa.fincaapp.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usa.fincaapp.entidades.Administrador;
import co.edu.usa.fincaapp.servicios.AdministradorServicio;

@RestController
@RequestMapping("api/Admin")
@CrossOrigin(origins = "*")

public class AdministradorController {
    @Autowired
    private AdministradorServicio administradorServicio;
    
    @GetMapping("/all")
    public List<Administrador> getAdmin() {
        return administradorServicio.getAdmins();
    }

    @GetMapping("/{id}")
    public Optional<Administrador> getAdminId(@PathVariable("id") Long adminId){
     return administradorServicio.getAdminById(adminId);
 }
    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Administrador saveAdmin(@RequestBody Administrador administrador) {
        return administradorServicio.saveAdmnin(administrador);
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Administrador updateAdmin(@RequestBody Administrador administrador) {
        return administradorServicio.updateAdmin(administrador);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(code  = HttpStatus.NO_CONTENT)
    public boolean deleteAdmin(@PathVariable("id") Long adminId) {
        return administradorServicio.deleteAdmin(adminId);
    }

}
