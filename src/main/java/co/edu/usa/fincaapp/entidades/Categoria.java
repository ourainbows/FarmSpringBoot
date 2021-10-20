package co.edu.usa.fincaapp.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="categorias")
public class Categoria implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",length = 45)
    private String name;

    @Column(name ="description", length = 250)
    private String description; 
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category")
    @JsonIgnoreProperties("category")
    public List<Finca> farms;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String nombre) {
        this.name = nombre;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String descripcion) {
        this.description = descripcion;
    }
    public List<Finca> getFarms() {
        return farms;
    }
    public void setFarms(List<Finca> farms) {
        this.farms = farms;
    }
}
