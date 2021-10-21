package co.edu.usa.fincaapp.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usa.fincaapp.entidades.Categoria;
import co.edu.usa.fincaapp.servicios.CategoriaServicio;


/**
 * Controlador de la categoria del las granjas
 */
@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*")
public class CategoriaController {
    @Autowired private CategoriaServicio categoriaServicio;    
    
    /**
     * Obtenemos todas las categorias existentes
     * @return categorias existentes
     */
    @GetMapping("/all")
    public List<Categoria> getCategoria() {
        return categoriaServicio.getAllCategories();
    }

    /**
     * Consultamos los datos completos de una categoria existente
     * @param CategoriaId -> el id que lleva la categoria que queremos consultar
     * @return los datos completos de la categoria 
     */
    @GetMapping("/{id}")
    public Optional<Categoria> getCategoriaId(@PathVariable("id") Long CategoriaId) {
        return categoriaServicio.getCategoryById(CategoriaId);
    }

    /**
     * Guardamos una nueva categoria
     * @param categoria -> los datos de la categoria nueva
     * @return -> la categoria nueva creada
     */
    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Categoria saveCategoria(@RequestBody Categoria categoria) {
        return categoriaServicio.saveCategory(categoria);
    }

    /**
     * Actualizamos una categoria existente
     * @param categoria -> el id de la categoria y los datos que queremos modificar
     * @return -> la categoria actualizada
     */
    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Categoria updateCategoria(@RequestBody Categoria categoria) {
        return categoriaServicio.updateCategory(categoria);

    }

    /**
     * Borramos una categoria a partir de su id
     * @param categoriaId -> el id de la categoria que queremos borrar
     * @return -> la categoria eliminada
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public boolean deleteCategoria(@PathVariable("id") Long categoriaId){
        return categoriaServicio.deleteCategory(categoriaId);
    }
}
