package loja.api.model.entity;

import loja.api.model.entity.pk.ItemCompraPK;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;



@Entity
public class ItemCompra implements  Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ItemCompraPK id = new ItemCompraPK();

    @Column(name = "quantidade")
    @NotNull
    private Integer quantidade;

    @Column(name = "preco")
    @NotNull
    private Double preco;

    public ItemCompra(){}

    public ItemCompra(Compra compra,Produto produto,Integer quantidade,Double preco) {
        super();
        id.setCompra(compra);
        id.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Compra getCompra(){
       return this.id.getCompra();
    }

    public Produto getProduto(){
        return this.id.getProduto();
    }


    public void setProduto(Produto entity){
        this.id.setProduto(entity);
    }

    public void setCompra(Compra entity){
        this.id.setCompra(entity);
    }


    public Double getSubTotal() {
        return preco * quantidade;
    }
}
