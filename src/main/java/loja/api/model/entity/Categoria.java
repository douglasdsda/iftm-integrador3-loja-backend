package loja.api.model.entity;

import loja.api.model.enums.TipoCategoria;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;



@Entity
public class Categoria implements  Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    @Column(name = "nome")
    @NotNull
    private String nome;

    @Column(name = "tipoCategoria")
    @NotNull
    private Integer tipoCategoria;

    @ManyToMany(mappedBy = "categorias")
    private Set<Produto> produtos = new HashSet<>();

    private Instant dataCriacao;

    private Instant dataAtualizacao;

    public Categoria(){}

    public Categoria(Long idCategoria, String nome, TipoCategoria tipoCategoria) {
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.tipoCategoria = tipoCategoria.getCode();
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCategoria getTipoCategoria() {
        return TipoCategoria.valueOf(tipoCategoria);
    }

    public void setTipoCategoria(TipoCategoria tipoCategoria) {
        this.tipoCategoria = tipoCategoria.getCode();
    }

    @PreUpdate
    public void preUpdate() {
        dataAtualizacao = Instant.now();
    }

    @PrePersist
    public void prePersist() {
        Instant now = Instant.now();
        dataAtualizacao = now;
        dataCriacao = now;
    }


    public Set<Produto> getProdutos() {
        return produtos;
    }
}
