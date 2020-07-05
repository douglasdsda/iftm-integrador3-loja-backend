package loja.api.dto;


public class EntregaDto {

  private Long idEntregador;

  private Long idCompra;

  public EntregaDto(){}

    public EntregaDto(Long idEntregador, Long idCompra) {
        this.idEntregador = idEntregador;
        this.idCompra = idCompra;
    }

    public Long getIdEntregador() {
        return idEntregador;
    }

    public void setIdEntregador(Long idEntregador) {
        this.idEntregador = idEntregador;
    }

    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }
}
