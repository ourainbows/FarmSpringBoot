package co.edu.usa.fincaapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping("/save")
    public Categoria saveCategoria(@RequestBody Categoria categoria) {
        return categoriaServicio.saveCategory(categoria);
    }
}
