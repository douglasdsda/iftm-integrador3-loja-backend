package loja.api.dto;
import loja.api.model.entity.Categoria;
import loja.api.model.entity.Produto;
import loja.api.model.enums.TipoCategoria;
import lombok.*;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ProdutoDto {

    private Long idProduto;

    private String nome;


    private String descricao;


    private Integer qtdEstoque;


    private double preco;

    private Long idCategoria;

    ProdutoDto(){}

    public ProdutoDto(Long idProduto, String nome, String descricao, Integer qtdEstoque, double preco, Long idCategoria) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.qtdEstoque = qtdEstoque;
        this.preco = preco;
        this.idCategoria = idCategoria;
    }

    public ProdutoDto(Produto entity) {
        setIdProduto(entity.getIdProduto());
        setNome(entity.getNome());
        setDescricao(entity.getDescricao());
        setPreco(entity.getPreco());
        setQtdEstoque(entity.getQtdEstoque());
        setIdCategoria(entity.getCategoria().getIdCategoria());

    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Produto toEntity() {
        return new Produto(null, nome,descricao , qtdEstoque, preco);
    }
}