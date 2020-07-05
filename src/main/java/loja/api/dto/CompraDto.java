package loja.api.dto;

import loja.api.model.entity.*;
import loja.api.model.enums.StatusCompra;
import loja.api.model.enums.StatusEntrega;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.*;


public class CompraDto {

    private Long idCompra;

    private StatusCompra statusCompra;

    private Instant data;

   private Long idCliente;

    private List<Item> itens = new ArrayList<>();

    CompraDto(){}

    public CompraDto(Long idCompra, StatusCompra statusCompra, Instant data, Long idCliente) {
        this.idCompra = idCompra;
        this.statusCompra = statusCompra;
        this.data = data;
        this.idCliente = idCliente;
    }

    public CompraDto(Compra entity) {
        setIdCompra(entity.getIdCompra());
        setStatusCompra(entity.getStatusCompra());
        setData(entity.getData());
        setIdCliente(entity.getCliente().getIdUsuario());
    }

    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public StatusCompra getStatusCompra() {
        return statusCompra;
    }

    public void setStatusCompra(StatusCompra statusCompra) {
        this.statusCompra = statusCompra;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}