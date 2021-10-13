package co.edu.usa.fincaapp.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Categoria;

@Repository
public class CategoriaRepository {
    @Autowired 
    private CategoriaCrudRepository categoriaRespositorio;
    
    public List<Categoria> getCategorias() {
        return (List<Categoria>) categoriaRespositorio.findAll();
    }

    public Optional<Categoria> getCategoriaporId(Long id) {
        return categoriaRespositorio.findById(id);
    }
    
    public Categoria guardaCategoria(Categoria categoria) {
        return categoriaRespositorio.save(categoria);
    }
}
