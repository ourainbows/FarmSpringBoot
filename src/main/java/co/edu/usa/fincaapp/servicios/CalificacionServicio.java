package co.edu.usa.fincaapp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.fincaapp.entidades.Calificacion;
import co.edu.usa.fincaapp.repositorios.CalificacionRepository;

@Service
public class CalificacionServicio {
    @Autowired
    private CalificacionRepository calificacionRepositorio;

    public List<Calificacion> getScore() {
        return calificacionRepositorio.getCalificacion();
    }

    public Optional<Calificacion> getScoreById(Long id) {
        return calificacionRepositorio.getCalificacionPorId(id);
    }

    public Calificacion saveScore(Calificacion calificacion) {
        if (calificacion != null) {
            if (calificacion.getId() != null) {
                Optional<Calificacion> oCalificaion = calificacionRepositorio
                        .getCalificacionPorId(calificacion.getId());
                if (oCalificaion.isEmpty()) {
                    return calificacionRepositorio.guardarCalificacion(calificacion);
                } else {
                    return calificacion;
                }
            } else {
                return calificacionRepositorio.guardarCalificacion(calificacion);
            }

        }
        return null;
    }
}
