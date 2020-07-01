package loja.api.model.entity;

import loja.api.model.entity.pk.EntregaPK;
import loja.api.model.entity.pk.ItemCompraPK;
import loja.api.model.enums.StatusEntrega;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
public class Entrega implements  Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private EntregaPK id = new EntregaPK();

    @Column(name = "data")
    @NotNull
    private Integer data;

    @Column(name = "statusEntrega")
    @NotNull
    private Integer statusEntrega;

    public Entrega(){}

    public Entrega(@NotNull Integer data,  StatusEntrega statusEntrega) {
        this.data = data;
        this.statusEntrega = statusEntrega.getCode();
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
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



}
