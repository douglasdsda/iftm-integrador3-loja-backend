package loja.api.model.entity;

import loja.api.model.enums.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity(name = "tb_usuario")
public abstract class Usuario implements  Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUsuario;

    @Column(name = "nome")
    @NotNull
    private String nome;

    @Column(name = "endereco")
    @NotNull
    private String endereco;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "tipoUsuario")
    private TipoUsuario tipoUsuario;

}
