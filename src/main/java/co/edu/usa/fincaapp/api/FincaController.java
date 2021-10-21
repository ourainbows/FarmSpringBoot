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

import co.edu.usa.fincaapp.entidades.Finca;
import co.edu.usa.fincaapp.servicios.FincaServicio;


/**
 * Controlador de Finca
 */
@RestController
@RequestMapping("/api/Farm")
@CrossOrigin(origins = "*")
public class FincaController {
    @Autowired
    //llamada al servicio
    private FincaServicio fincaServicio;

    /**
     * Obtenemos todos las fincas existentes
     * @return las fincas
     */
    @GetMapping("/all")
    public List<Finca> getFinca() {
        return fincaServicio.getFarms();
    }
    
    /**
     * Obtenemos una finca a partir de su id
     * @param fincaId -> el id de la finca que queremos consultar 
     * @return los datos completos de la finca
     */
    @GetMapping("/{id}")
    public Optional<Finca> getFincaId(@PathVariable("id") Long fincaId) {
        return fincaServicio.getFarmById(fincaId);
    }

    /**
     * Guardamos una nueva finca
     * @param finca -> los datos de la finca nueva que vamos a guardar
     * @return la finca guardada
     */
    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Finca saveFinca(@RequestBody Finca finca) {
        return fincaServicio.saveFarm(finca);
    }
    
    /**
     * Actualizamos una finca
     * @param finca -> el id de la finca y los datos que vamos a actualizar
     * @return la finca actualizada
     */
    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Finca updateFinca(@RequestBody Finca finca) {
        return fincaServicio.updateFarm(finca);
    }

    /**
     * Borramos una finca a partir de su id
     * @param fincaId -> el id de la finca que vamos a borrar
     * @return -> la finca borrada
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(code  = HttpStatus.NO_CONTENT)
    public boolean deleteFinca(@PathVariable("id") Long fincaId) {
        return fincaServicio.deleteFarm(fincaId);
    }
}
