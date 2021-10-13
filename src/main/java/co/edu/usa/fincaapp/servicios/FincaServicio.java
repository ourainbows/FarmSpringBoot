package co.edu.usa.fincaapp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.fincaapp.entidades.Finca;
import co.edu.usa.fincaapp.repositorios.FincaRepository;

@Service
public class FincaServicio {
    @Autowired
    private FincaRepository fincaRepository;
    
    public List<Finca> getFarms() {
        return fincaRepository.getFincas();
    }

    public Optional<Finca> getFarmById(Long id) {
        return fincaRepository.getFincaPorId(id);
    }
    public Finca saveFarm(Finca finca){
        if (finca != null) {
            if (finca.getId() != null) {
                Optional<Finca> oFinca = fincaRepository.getFincaPorId(finca.getId());
                if (oFinca.isEmpty()) {
                    return fincaRepository.guardarFinca(finca);
                } else {
                    return finca;
                }
            } else {
                return fincaRepository.guardarFinca(finca);
            }
        }
        return null;
    }
}