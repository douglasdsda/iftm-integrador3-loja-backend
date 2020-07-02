package loja.api.dto;
import loja.api.model.enums.TipoUsuario;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {

    private String cpf;

    private String urlImagem;

    private boolean ativo;

    private String nome;

    private String endereco;

    private String email;

    private String senha;

    private String sexo;

}