package co.edu.usa.fincaapp.entidades;

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
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="startDate")
    private String startDate;
    @Column(name="endDate")
    private String endDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties("reservas")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    @JsonIgnoreProperties("reservas")
    private Finca finca;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "reservas")
    @JsonIgnoreProperties("reservas")
    private List<Calificacion> calificaciones;

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

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}