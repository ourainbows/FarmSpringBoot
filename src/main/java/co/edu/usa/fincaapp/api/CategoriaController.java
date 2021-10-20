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

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*")
public class CategoriaController {
    @Autowired private CategoriaServicio categoriaServicio;    
    
    @GetMapping("/all")
    public List<Categoria> getCategoria() {
        return categoriaServicio.getAllCategories();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> getCategoriaId(@PathVariable("id") Long CategoriaId) {
        return categoriaServicio.getCategoryById(CategoriaId);
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Categoria saveCategoria(@RequestBody Categoria categoria) {
        return categoriaServicio.saveCategory(categoria);
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Categoria updateCategoria(@RequestBody Categoria categoria) {
        return categoriaServicio.updateCategory(categoria);

    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public boolean deleteCategoria(@PathVariable("id") Long categoriaId){
        return categoriaServicio.deleteCategory(categoriaId);
    }
}
