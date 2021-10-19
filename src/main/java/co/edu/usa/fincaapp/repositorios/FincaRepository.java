package co.edu.usa.fincaapp.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Finca;

@Repository
public class FincaRepository {
    @Autowired 
    private FincaCrudRepository fincaRepoitorio;

    public Optional<Finca> getFincaPorId(Long idFinca){
         return  fincaRepoitorio.findById(idFinca);
    }
    public List<Finca> getFincas(){
        return (List<Finca>)fincaRepoitorio.findAll();
    }
    public Finca guardarFinca(Finca finca){
        return fincaRepoitorio.save(finca);
    }
    public void borrarFinca(Finca finca){
        fincaRepoitorio.delete(finca);
    }
}
