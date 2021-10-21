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


/**
 * Controlador de adminitrador
 */
@RestController
@RequestMapping("api/Admin")
@CrossOrigin(origins = "*")
public class AdministradorController {

    @Autowired
    //Llamado al servicio
    private AdministradorServicio administradorServicio;
    
    /**
     * Objetemos todos los administradores
     */
    @GetMapping("/all")
    public List<Administrador> getAdmin() {
        return administradorServicio.getAdmins();
    }

    /**
     * Obtenemos un administrador por su id 
     * @param adminId -> el id del admin a consultar
     * @return -> el objeto completo de los datos del admin
     */
    @GetMapping("/{id}")
    public Optional<Administrador> getAdminId(@PathVariable("id") Long adminId) {
        return administradorServicio.getAdminById(adminId);
    }
 
    /**
     * Guardamos un nuevo administrador
     * @param administrador -> los datos del administrador que vamos a guardar
     * @return -> el objeto del administrador guardado
     */
    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Administrador saveAdmin(@RequestBody Administrador administrador) {
        return administradorServicio.saveAdmnin(administrador);
    }

    /**
     * Actualizamos un administrador
     * @param administrador -> los datos que queramos actualizar de un admin existente y su id para identificarlo
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Administrador updateAdmin(@RequestBody Administrador administrador) {
        return administradorServicio.updateAdmin(administrador);
    }
    
    /**
     * Booramos un administrador a partir de su id
     * @param adminId -> el id del administrador que vamos a eliminar
     * @return -> el administrador eliminado
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(code  = HttpStatus.NO_CONTENT)
    public boolean deleteAdmin(@PathVariable("id") Long adminId) {
        return administradorServicio.deleteAdmin(adminId);
    }

}
