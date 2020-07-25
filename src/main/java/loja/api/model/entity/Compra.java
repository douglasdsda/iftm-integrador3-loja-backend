package loja.api.model.entity;

import loja.api.dto.Item;
import loja.api.model.enums.StatusCompra;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Compra implements  Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompra;

    @Column(name = "data")
    @NotNull
    private Instant data;

    @Column(name = "statusCompra")
    @NotNull
    private Integer statusCompra;

    @OneToOne(mappedBy = "compra", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Cliente cliente;

    @OneToMany(mappedBy = "id.compra")
    private List<ItemCompra> itens = new ArrayList<>();



    public Compra(){}

    public Compra(Long idCompra, Instant data, StatusCompra statusCompra) {
        this.idCompra = idCompra;
        this.data = data;
        this.statusCompra = statusCompra.getCode();
    }

    public Compra(Long idCompra,  StatusCompra statusCompra,  List<ItemCompra> itens) {
        this.idCompra = idCompra;
        this.statusCompra = statusCompra.getCode();
        this.itens = itens;
    }

    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public StatusCompra getStatusCompra() {
        return StatusCompra.valueOf(statusCompra);
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void setStatusCompra(StatusCompra statusCompra) {
        this.statusCompra = statusCompra.getCode();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public List<ItemCompra> getItens(){
        return itens;
    }

    @PrePersist
    public void prePersist() {
        Instant now = Instant.now();
        data = now;
    }
}
