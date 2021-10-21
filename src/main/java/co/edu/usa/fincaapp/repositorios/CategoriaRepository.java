package co.edu.usa.fincaapp.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Categoria;

/**
 * Creamos el CRUD
 */
@Repository
public class CategoriaRepository {
    @Autowired 
    private CategoriaCrudRepository categoriaRespositorio;
    
    /**
     * GET
     * @return
     */
    public List<Categoria> getCategorias() {
        return (List<Categoria>) categoriaRespositorio.findAll();
    }

    /**
     * GET BY ID
     * @param id
     * @return
     */
    public Optional<Categoria> getCategoriaPorId(Long id) {
        return categoriaRespositorio.findById(id);
    }
    
    /**
     * CREATE - UPDATE
     * @param categoria
     * @return
     */
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRespositorio.save(categoria);
    }

    /**
     * DELETE
     * @param categoria
     */
    public void borrarCategoria(Categoria categoria) {
        categoriaRespositorio.delete(categoria);
    }
}
