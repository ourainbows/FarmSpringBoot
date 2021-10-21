package co.edu.usa.fincaapp.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Finca;

/**
 * Creamos el CRUD
 */
@Repository
public class FincaRepository {
    @Autowired 
    private FincaCrudRepository fincaRepoitorio;

    /**
     * GET
     * @return
     */
    public List<Finca> getFincas() {
        return (List<Finca>) fincaRepoitorio.findAll();
    }
    
    /**
     * GET BY ID
     * @param idFinca
     * @return
     */
    public Optional<Finca> getFincaPorId(Long idFinca) {
        return fincaRepoitorio.findById(idFinca);
    }
    
    /**
     * CREATE - UPDATE
     * @param finca
     * @return
     */
    public Finca guardarFinca(Finca finca) {
        return fincaRepoitorio.save(finca);
    }
    
    /**
     * DELETE
     * @param finca
     */
    public void borrarFinca(Finca finca){
        fincaRepoitorio.delete(finca);
    }
}
