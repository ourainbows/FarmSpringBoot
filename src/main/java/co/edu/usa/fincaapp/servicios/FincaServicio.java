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
    private FincaRepository fincaRepositorio;
    
    public List<Finca> getFarms() {
        return fincaRepositorio.getFincas();
    }

    public Optional<Finca> getFarmById(Long id) {
        return fincaRepositorio.getFincaPorId(id);
    }

    public Finca saveFarm(Finca finca) {
        // Comprobamos que no tengamos un objeto vacio
        if (finca != null) {
            // En caso de que nos hayan pasado un objeto sin id
            if (finca.getId() == null) {
                return fincaRepositorio.guardarFinca(finca);
            } else {
                // Consultamos si tenemos un objeto con ese id en la base de datos
                Optional<Finca> oFinca = fincaRepositorio.getFincaPorId(finca.getId());
                // Si no existe un objeto con ese id lo guardamos
                if (oFinca.isEmpty()) {
                    return fincaRepositorio.guardarFinca(finca);
                    // Objeto existente en la base de datos
                } else {
                    return finca;
                }
            }
        }
        // Objeto vacio
        return finca;
    }
    
    public Finca updateFarm(Finca finca) {
        // Comprobamos que nuestro objeto lleve un id
        if (finca.getId() != null) {
            Optional<Finca> oFinca = fincaRepositorio.getFincaPorId(finca.getId());
            // Comprobamos que nuestro objeto exista en la base de datos para poder
            // actualizarlo
            if (!oFinca.isEmpty()) {
                // Comprobamos cada atributo para saber si es vacio, en caso de no serlo lo
                // actualizamos
                if (finca.getName() != null) {
                    oFinca.get().setName(finca.getName());
                }
                if (finca.getAddress() != null) {
                    oFinca.get().setAddress(finca.getAddress());
                }
                if (finca.getExtension() != null) {
                    oFinca.get().setExtension(finca.getExtension());
                }
                if (finca.getDescription() != null) {
                    oFinca.get().setDescription(finca.getDescription());
                }
                // Actualizamos la informacion
                fincaRepositorio.guardarFinca(oFinca.get());
                return oFinca.get();
            } else {
                return finca;
            }
        } else {
            return finca;
        }
    }

    public boolean deleteFarm(Long id) {
        Boolean borrado = getFarmById(id).map(farm -> {
            fincaRepositorio.borrarFinca(farm);
            return true;
        }).orElse(false);
        return borrado;
    }
}