package co.edu.usa.fincaapp.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Calificacion;

/**
 * Creamos el CRUD
 */
@Repository
public class CalificacionRepository {
    @Autowired
    private CalificacionCrudRepository calificacionRespositorio;

    /**
     * GET
     */
    public List<Calificacion> getCalificacion() {
        return (List<Calificacion>) calificacionRespositorio.findAll();
    }

    /**
     * GET BY ID
     * @param id
     * @return
     */
    public Optional<Calificacion> getCalificacionPorId(Long id) {
        return calificacionRespositorio.findById(id);
    }

    /**
     * CREATE - UPDATE
     */
    public Calificacion guardarCalificacion(Calificacion calificacion) {
        return calificacionRespositorio.save(calificacion);
    }

    /**
     * DELETE
     * @param calificacion
     */
    public void borrarCalificacion(Calificacion calificacion) {
        calificacionRespositorio.delete(calificacion);
    }
}
