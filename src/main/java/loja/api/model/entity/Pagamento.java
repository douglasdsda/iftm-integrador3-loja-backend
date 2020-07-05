package loja.api.model.entity;

import loja.api.model.enums.TipoCategoria;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Pagamento implements  Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPagamento;

    @Column(name = "data")
    @NotNull
    private Instant data;

    public Pagamento(){}

    public Pagamento(Long idPagamento, Compra compra) {
        this.idPagamento = idPagamento;
        this.compra = compra;
    }

    @OneToOne
    @MapsId
    private Compra compra;

    public Long getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Long idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    @PrePersist
    public void prePersist() {
        Instant now = Instant.now();
        data = now;
    }

}
