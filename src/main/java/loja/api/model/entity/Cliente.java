package loja.api.model.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Setter
@Getter
@PrimaryKeyJoinColumn(name="idPessoa")
public class Cliente extends Usuario {

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "urlImagem")
    private String urlImagem;

    @Column(name = "ativo")
    private boolean ativo;

    public Cliente(){}

    public Cliente(String cpf, String urlImagem, boolean ativo) {
        this.cpf = cpf;
        this.urlImagem = urlImagem;
        this.ativo = ativo;
    }

    public Cliente(Long idUsuario, @NotNull String nome, @NotNull String endereco, String email, String senha, String sexo, String cpf, String urlImagem, boolean ativo) {
        super(idUsuario, nome, endereco, email, senha, sexo);
        this.cpf = cpf;
        this.urlImagem = urlImagem;
        this.ativo = ativo;
    }
}