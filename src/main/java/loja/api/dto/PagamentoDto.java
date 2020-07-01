package loja.api.dto;

import loja.api.model.entity.Compra;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;


@Builder
@Setter
@Getter
public class PagamentoDto {

    private Long idPagamento;

    private Long idCompra;

    private Instant data;

}