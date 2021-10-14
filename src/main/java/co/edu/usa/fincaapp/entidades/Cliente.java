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
    private Long id;
    @Column(name = "name", length = 250)
    private String name;
    @Column(name = "email", length = 45)
    private String email;
    @Column
    private Integer age;
    @Column(name = "password", length = 45)
    private String password;



    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "cliente")
    @JsonIgnoreProperties("cliente")
    private List<Reserva> reserva;
    


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
