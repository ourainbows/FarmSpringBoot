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
@Table(name="clientes")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // *********
    private Long idClient;
    // **********
    @Column(name = "email", length = 45)
    private String email;
    @Column(name = "password", length = 45)
    private String password;
    @Column(name = "name", length = 250)
    private String name;
    @Column
    private Integer age;
    
    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "client")
    @JsonIgnoreProperties("client")
    //@JsonIgnoreProperties({("client"),("reservations")})
    private List<Mensaje> messages;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Reserva> reservations;

    public Long getIdClient() {
        return idClient;
    }
    public List<Reserva> getReservations() {
        return reservations;
    }
    public void setReservations(List<Reserva> reservations) {
        this.reservations = reservations;
    }
    public List<Mensaje> getMessages() {
        return messages;
    }
    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }
    public void setIdClient(Long id) {
        this.idClient = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String nombre) {
        this.name = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer edad) {
        this.age = edad;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String contrasena) {
        this.password = contrasena;
    }
    

}
