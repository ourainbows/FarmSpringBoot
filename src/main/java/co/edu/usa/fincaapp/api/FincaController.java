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

@RestController
@RequestMapping("/api/Farm")
@CrossOrigin(origins = "*")

public class FincaController {
    @Autowired
    private FincaServicio fincaServicio;

    @GetMapping("/all")
    public List<Finca> getFinca() {
        return fincaServicio.getFarms();
    }
    
    @GetMapping("/{id}")
    public Optional<Finca> getFincaId(@PathVariable("id") Long fincaId) {
        return fincaServicio.getFarmById(fincaId);
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Finca saveFinca(@RequestBody Finca finca) {
        return fincaServicio.saveFarm(finca);
    }
    
    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Finca updateFinca(@RequestBody Finca finca) {
        return fincaServicio.updateFarm(finca);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code  = HttpStatus.NO_CONTENT)
    public boolean deleteFinca(@PathVariable("id") Long fincaId) {
        return fincaServicio.deleteFarm(fincaId);
    }
}
