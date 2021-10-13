package co.edu.usa.fincaapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usa.fincaapp.entidades.Finca;
import co.edu.usa.fincaapp.servicios.FincaServicio;

@RestController
@RequestMapping("/api/Farm")
@CrossOrigin(origins = "*")

public class FincaController {
    @Autowired private FincaServicio fincaServicio;

    @GetMapping("/all")
    public List<Finca> getFinca(){
        return fincaServicio.getFarms();
    }

    @PostMapping("/save")
    public Finca saveFinca(@RequestBody Finca finca){
        return fincaServicio.saveFarm(finca);
    }
    
}
