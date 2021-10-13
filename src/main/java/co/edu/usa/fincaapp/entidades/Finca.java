package co.edu.usa.fincaapp.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="fincas")
public class Finca implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="address", length = 45)
    private String address;
    @Column(name="exension")
    private Double exension;
    @Column(name="name", length = 45)
    private String name;
    @Column(name = "description", length = 250)
    private String description;

    @ManyToOne
    @JoinColumn(name="categoryId")
    @JsonIgnoreProperties("fincas")
    private Categoria categoria;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "finca")
    @JsonIgnoreProperties("finca")
    public List<Mensaje> mensajes;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "finca")
    @JsonIgnoreProperties("finca")
    public List<Reserva> reservas;
   
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Double getExension() {
        return exension;
    }
    public void setExension(Double exension) {
        this.exension = exension;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }



}
