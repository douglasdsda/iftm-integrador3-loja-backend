package loja.api.dto;
import loja.api.model.entity.Categoria;
import loja.api.model.entity.Produto;
import loja.api.model.enums.TipoCategoria;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDto {

    private Long idCategoria;

    private String nome;

    private TipoCategoria tipoCategoria;

    public CategoriaDto(){}

    public CategoriaDto(Long idCategoria, String nome, TipoCategoria tipoCategoria) {
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.tipoCategoria = tipoCategoria;
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
        return tipoCategoria;
    }

    public void setTipoCategoria(TipoCategoria tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }


    public Categoria toEntity() {
        return new Categoria(null, nome, tipoCategoria);
    }
}