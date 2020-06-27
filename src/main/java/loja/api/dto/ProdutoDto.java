package loja.api.dto;
import loja.api.model.entity.Categoria;
import loja.api.model.entity.Produto;
import loja.api.model.enums.TipoCategoria;
import lombok.*;

import javax.persistence.Column;
import java.util.HashSet;
import java.util.Set;


@Builder
@Setter
@Getter
public class ProdutoDto {

    private Long idProduto;

    private String nome;


    private String descricao;


    private Integer qtdEstoque;


    private double preco;

    ProdutoDto(){}

    public ProdutoDto(Long idProduto, String nome, String descricao, Integer qtdEstoque, double preco) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.qtdEstoque = qtdEstoque;
        this.preco = preco;
    }

    public ProdutoDto(Produto entity) {
        setIdProduto(entity.getIdProduto());
        setNome(entity.getNome());
        setDescricao(entity.getDescricao());
        setPreco(entity.getPreco());
        setQtdEstoque(entity.getQtdEstoque());

    }
}