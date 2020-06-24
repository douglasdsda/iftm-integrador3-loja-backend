package loja.api.model.entity;

import loja.api.model.enums.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance
@MappedSuperclass
public abstract class Usuario extends Pessoa {

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "tipoUsuario")
    private TipoUsuario tipoUsuario;

}
