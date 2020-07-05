package loja.api.dto;

import loja.api.model.entity.Compra;
import loja.api.model.entity.Pagamento;
import loja.api.model.entity.Produto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;



public class PagamentoDto {

    private Long idPagamento;

    private Long idCompra;

    private Instant data;

    PagamentoDto(){}

    PagamentoDto(Pagamento entity){
        setIdCompra(entity.getIdPagamento());
        setData(entity.getData());
        setIdPagamento(entity.getIdPagamento());
    }

    public Long getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Long idPagamento) {
        this.idPagamento = idPagamento;
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


}