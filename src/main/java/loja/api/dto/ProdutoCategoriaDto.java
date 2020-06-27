package loja.api.dto;

import loja.api.model.entity.Produto;
import lombok.*;

import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ProdutoCategoriaDto  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;


    private String descricao;


    @Positive
    private Integer qtdEstoque;

    @Positive
    private double preco;

    private List<CategoriaDto> categorias = new ArrayList<>();

    public ProdutoCategoriaDto(){}

    public ProdutoCategoriaDto(String nome, String descricao,  Integer qtdEstoque,  double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.qtdEstoque = qtdEstoque;
        this.preco = preco;
    }

    public ProdutoCategoriaDto(Produto entity) {
        setNome(entity.getNome());
        setDescricao(entity.getDescricao());
        setPreco(entity.getPreco());
        setQtdEstoque(entity.getQtdEstoque());
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }


    public List<CategoriaDto> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaDto> categorias) {
        this.categorias = categorias;
    }

    public Produto toEntity() {
        return new Produto(null, nome,descricao , qtdEstoque, preco);
    }
}
