package co.edu.usa.fincaapp.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "calificacion")
/**
 * Creamos un objeto calificacion, estas calificaciones se le dan a una reservacion
 */
public class Calificacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Primary Key
    
    @Column(name="score")
    private Integer score;
    @Column(name="text", length = 250)
    private String text;

    //Relaciones con el objeto reserva
    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "reserva", referencedColumnName = "idReservation")
    //@JsonIgnoreProperties("score")
    private Reserva reserva;


    // Getters & Setters
    public Reserva getReserva() {
        return reserva;
    }
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score) {
        this.score = score;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    
    
}
