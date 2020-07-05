package loja.api.model.entity;

import loja.api.model.entity.pk.EntregaPK;
import loja.api.model.entity.pk.ItemCompraPK;
import loja.api.model.enums.StatusEntrega;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;


@Entity
public class Entrega implements  Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private EntregaPK id = new EntregaPK();

    @Column(name = "data")
    @NotNull
    private Instant data;

    @Column(name = "statusEntrega")
    @NotNull
    private Integer statusEntrega;

    public Entrega(){}

    public Entrega(Entregador entregador, Compra compra) {
        this.id.setEntregador(entregador);
        this.id.setCompra(compra);
    }

    public Entrega(StatusEntrega statusEntrega) {
          this.statusEntrega = statusEntrega.getCode();
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public StatusEntrega getStatusEntrega() {
        return StatusEntrega.valueOf(statusEntrega);
    }

    public void setStatusEntrega(StatusEntrega statusEntrega) {
        this.statusEntrega = statusEntrega.getCode();
    }

    public Entregador getEntregador(){
       return this.id.getEntregador();
    }

    public Compra getCompra(){
        return this.id.getCompra();
    }


    public void setEntregador(Entregador entity){
        this.id.setEntregador(entity);
    }

    public void setCompra(Compra entity){
        this.id.setCompra(entity);
    }

    @PrePersist
    public void prePersist() {
        Instant now = Instant.now();
        data = now;
    }

}
