package loja.api.dto;


import loja.api.model.entity.Compra;
import loja.api.model.entity.Entregador;

public class EntregaListaDto {

  private Entregador entregador;

  private CompraDto compra;

  public EntregaListaDto(){}


    public Entregador getEntregador() {
        return entregador;
    }

    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }

    public CompraDto getCompra() {
        return compra;
    }

    public void setCompra(CompraDto compra) {
        this.compra = compra;
    }
}
