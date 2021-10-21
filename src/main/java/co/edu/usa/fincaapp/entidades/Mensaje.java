package co.edu.usa.fincaapp.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Objeto mensaje, un cliente puede dejar un mensaje de una finca en particular
 */
@Entity
@Table(name="mensajes")
public class Mensaje implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMessage;

    @Column(name="messageText", length = 250)
    private String messageText;
    
    @ManyToOne
    @JoinColumn(name = "farm")
    @JsonIgnoreProperties({ "messages", "client", "reservations" })
    private Finca farm;

    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties({ "messages", "reservations", "client" })
    private Cliente client;

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public Finca getFarm() {
        return farm;
    }

    public void setFarm(Finca farm) {
        this.farm = farm;
    }

    public Long getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Long id) {
        this.idMessage = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }



    
    
}
