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
    @Column(name = "name", length = 45)
    private String name;
    @Column(name="address", length = 45)
    private String address;
    @Column(name="extension")
    private Integer extension;
    @Column(name = "description", length = 250)
    private String description;

    @ManyToOne
    @JoinColumn(name="category")
    @JsonIgnoreProperties("farms")
    private Categoria category;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "farm")
    @JsonIgnoreProperties("farm")
    public List<Mensaje> messages;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "farm")
    @JsonIgnoreProperties("farm")
    public List<Reserva> reservations;
   
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Categoria getCategory() {
        return category;
    }
    public void setCategory(Categoria category) {
        this.category = category;
    }
    public List<Mensaje> getMessages() {
        return messages;
    }
    public void setMessages(List<Mensaje> mensajes) {
        this.messages = mensajes;
    }
    public List<Reserva> getReservations() {
        return reservations;
    }
    public void setReservations(List<Reserva> reservas) {
        this.reservations = reservas;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getExtension() {
        return extension;
    }
    public void setExtension(Integer exension) {
        this.extension = exension;
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
