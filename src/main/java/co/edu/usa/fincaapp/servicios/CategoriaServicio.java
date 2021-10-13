package co.edu.usa.fincaapp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.fincaapp.entidades.Categoria;
import co.edu.usa.fincaapp.repositorios.CategoriaRepository;

@Service
public class CategoriaServicio {
    @Autowired
    private CategoriaRepository categoriaRepositorio;

    public List<Categoria> getAllCategories() {
        return categoriaRepositorio.getCategorias();
    }

    public Optional<Categoria> getCategoryById(Long id) {
        return categoriaRepositorio.getCategoriaporId(id);
    }

    public Categoria saveCategory(Categoria categoria) {
        if (categoria != null) {
            if (categoria.getId() != null) {
                Optional<Categoria> oCategoria = categoriaRepositorio.getCategoriaporId(categoria.getId());
                if (oCategoria.isEmpty()) {
                    return categoriaRepositorio.guardaCategoria(categoria);
                } else {
                    return categoria;
                }
            } else {
                return categoriaRepositorio.guardaCategoria(categoria);
            }
        }
        return null; 
    }
}