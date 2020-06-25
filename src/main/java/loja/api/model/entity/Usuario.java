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
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "tb_usuario")
public abstract class Usuario implements  Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

  //  @Column(name = "tipoUsuario")
  //  private TipoUsuario tipoUsuario;

}
