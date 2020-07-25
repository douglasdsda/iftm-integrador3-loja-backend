package loja.api.model.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Setter
@Getter
@PrimaryKeyJoinColumn(name="idUsuario")
public class Administrador extends Usuario {

    @Column(name = "ultimo_ajuste")
    private String ultimoAjuste;



    public Administrador(String ultimoAjuste) {
        this.ultimoAjuste = ultimoAjuste;
    }

    public Administrador(Long idUsuario, @NotNull String nome, @NotNull String endereco, String email, String senha, String sexo, String ultimoAjuste) {
        super(idUsuario, nome, endereco, email, senha, sexo);
        this.ultimoAjuste = ultimoAjuste;
    }
}