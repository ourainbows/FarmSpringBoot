package co.edu.usa.fincaapp.entidades;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "reservas")
public class Reserva implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="startDate")
    private Date startDate;
    @Column(name="devolutionDate")
    private Date devolutionDate;
  
    // Status -> Created
    private String status = "created";

    @ManyToOne
    @JoinColumn(name = "farm")
    @JsonIgnoreProperties("reservations") 
    private Finca farm;

    
    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties({ ("reservations"), ("messages") })
    public Cliente client;

    /*    private String score;  */
 
    @OneToOne(mappedBy = "reserva")
    //@JsonIgnoreProperties("reservation")
    public Calificacion score;
   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Calificacion getScore() {
        return score;
    }

    public void setScore(Calificacion score) {
        this.score = score;
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

/*     public Set<Calificacion> getScore() {
        return score;
    }

    public void setScore(Set<Calificacion> score) {
        this.score = score;
    } */
}