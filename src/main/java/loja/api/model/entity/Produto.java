package loja.api.model.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    @Column(name = "nome")
    @NotNull
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "qtdEstoque")
    private Integer qtdEstoque;

    @Column(name = "preco")
    private double preco;

    @ManyToMany
    @JoinTable(name = "Produto_Categoria",
            joinColumns = @JoinColumn(name = "idProduto"),
            inverseJoinColumns = @JoinColumn(name = "idCategoria")
    )
    private Set<Categoria> categorias = new HashSet<>();

    @OneToMany(mappedBy = "id.produto")
    private Set<ItemCompra> itens = new HashSet<>();

    public Produto(){}

    public Produto(Long idProduto,  String nome, String descricao, Integer qtdEstoque, double preco) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.qtdEstoque = qtdEstoque;
        this.preco = preco;
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

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public Set<Compra> getCompras(){
        Set<Compra> set = new HashSet<>();
        for(ItemCompra x : itens) {
            set.add(x.getCompra());
        }
        return set;
    }
}
