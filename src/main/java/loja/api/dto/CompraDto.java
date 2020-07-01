package loja.api.dto;

import loja.api.model.entity.Cliente;
import loja.api.model.entity.Compra;
import loja.api.model.entity.ItemCompra;
import loja.api.model.entity.Produto;
import loja.api.model.enums.StatusCompra;
import loja.api.model.enums.StatusEntrega;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Setter
@Getter
public class CompraDto {

    private Long idCompra;

    private StatusCompra statusCompra;

    private Instant data;


   private Cliente cliente;


    @OneToMany(mappedBy = "cliente")
    private List<Compra> orders = new ArrayList<>();


    CompraDto(){}

    public CompraDto(Long idCompra, StatusCompra statusCompra, Instant data, Cliente cliente) {
        this.idCompra = idCompra;
        this.statusCompra = statusCompra;
        this.data = data;
        this.cliente = cliente;
    }

    public CompraDto(Compra entity) {
        setIdCompra(entity.getIdCompra());
        setStatusCompra(StatusCompra.valueOf(entity.getStatusCompra()));
        setData(entity.getData());
        setCliente(entity.getCliente());
    }
}