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
        // Comprobamos que no tengamos un objeto vacio
        if (calificacion != null) {
            // En caso de que nos hayan pasado un objeto sin id
            if (calificacion.getId() != null) {
                return calificacionRepositorio.guardarCalificacion(calificacion);
            }else{
                // Consultamos si tenemos un objeto con ese id en la base de datos
                Optional<Calificacion> oCalificacion = calificacionRepositorio.getCalificacionPorId(calificacion.getId());
                // Si no existe un objeto con ese id lo guardamos
                if(oCalificacion.isEmpty()){
                    return calificacionRepositorio.guardarCalificacion(calificacion);
                // Objeto existente en la base de datos
                }else{
                    return calificacion;
                }
            }
        }
        // Objeto vacio
        return calificacion;
    }


    public Calificacion updateScore(Calificacion score) {
        // Comprobamos que nuestro objeto lleve un id
        if (score.getId() != null) {
            Optional<Calificacion> oCalificacion = calificacionRepositorio.getCalificacionPorId(score.getId());
            // Comprobamos que nuestro objeto exista en la base de datos para poder actualizarlo
            if (!oCalificacion.isEmpty()) {
                // Comprobamos cada atributo para saber si es vacio, en caso de no serlo lo actualizamos
                if (score.getScore() != null) {
                    oCalificacion.get().setScore(score.getScore());
                }
                if (score.getText() != null) {
                    oCalificacion.get().setText(score.getText());
                }
                if (score.getReserva() != null) {
                    oCalificacion.get().setReserva(score.getReserva());
                }
                calificacionRepositorio.guardarCalificacion(oCalificacion.get());
                return oCalificacion.get();
            } else {
                return score;
            }
        } else {
            return score;
        }
    }
    
    public boolean deleteScore(Long id) {
        Boolean borrado = getScoreById(id).map(score -> {
            calificacionRepositorio.borrarCalificacion(score);
            return true;
        }).orElse(false);
        return borrado;
    }

}
