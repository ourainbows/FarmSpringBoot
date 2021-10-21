package co.edu.usa.fincaapp.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "reservas")
/**
 * Objeto Reserva en el cual guardamos las reservaciones que se le hacen a las fincas
 */
public class Reserva implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @Column(name="startDate")
    private Date startDate;
    @Column(name="devolutionDate")
    private Date devolutionDate;
  
    // Status -> Created
    private String status = "created";

    // relacion con farm
    @ManyToOne
    @JoinColumn(name = "farm")
    @JsonIgnoreProperties("reservations") 
    private Finca farm;

    // relacion con el objeto cliente
    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties({"reservations","messages"})
    public Cliente client;

    // Relacion de uno a uno con el objeto score que es el puntaje que se le da a una reservacion
    @OneToOne(mappedBy = "reserva")
    public Calificacion score;


    // Getters & Setters
    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
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