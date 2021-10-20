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
        return categoriaRepositorio.getCategoriaPorId(id);
    }

    public Categoria saveCategory(Categoria categoria) {
        // Comprobamos que no tengamos un objeto vacio
        if (categoria != null) {
            // En caso de que nos hayan pasado un objeto sin id
            if (categoria.getId() != null) {
                return categoriaRepositorio.guardarCategoria(categoria);
            } else {
                // Consultamos si tenemos un objeto con ese id en la base de datos
                Optional<Categoria> oCategoria = categoriaRepositorio.getCategoriaPorId(categoria.getId());
                // Si no existe un objeto con ese id lo guardamos
                if (oCategoria.isEmpty()) {
                    return categoriaRepositorio.guardarCategoria(categoria);
                    // Objeto existente en la base de datos
                } else {
                    return categoria;
                }
            }
        }
        // Objeto vacio
        return categoria;
    }

    public Categoria updateCategory(Categoria categoria) {
        // Comprobamos que nuestro objeto lleve un id
        if (categoria.getId() != null) {
            Optional<Categoria> oCategoria = categoriaRepositorio.getCategoriaPorId(categoria.getId());
            // Comprobamos que nuestro objeto exista en la base de datos para poder actualizarlo
            if (!oCategoria.isEmpty()) {
                // Comprobamos cada atributo para saber si es vacio, en caso de no serlo lo actualizamos
                if (categoria.getName() != null) {
                    oCategoria.get().setName(categoria.getName());
                }
                if (categoria.getDescription() != null) {
                    oCategoria.get().setDescription(categoria.getDescription());
                }
                // Actualizamos la informacion
                categoriaRepositorio.guardarCategoria(oCategoria.get());
                return oCategoria.get();
            } else {
                return categoria;
            }
        } else {
            return categoria;
        }
    }

    public boolean deleteCategory(Long id) {
        Boolean borrado = getCategoryById(id).map(category -> {
            categoriaRepositorio.borrarCategoria(category);
            return true;
        }).orElse(false);
        return borrado;
    }
}