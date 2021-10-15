package co.edu.usa.fincaapp.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

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
@Table(name = "reservas")
public class Reserva implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="startDate")
    private String startDate;
    @Column(name="devolutionDate")
    private String devolutionDate;
  
    // Status -> Created

    @ManyToOne
    @JoinColumn(name = "farm")
    @JsonIgnoreProperties("reservations") 
    private Finca farm;

    
    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties({ ("reservations"), ("messages") })
    public Cliente client;


    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "reservation")
    @JsonIgnoreProperties("reservation")
    public Set<Calificacion> score; 
 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(String endDate) {
        this.devolutionDate = endDate;
    }

    public Finca getFarm() {
        return farm;
    }

    public void setFarm(Finca farm) {
        this.farm = farm;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public Set<Calificacion> getScore() {
        return score;
    }

    public void setScore(Set<Calificacion> score) {
        this.score = score;
    }
}