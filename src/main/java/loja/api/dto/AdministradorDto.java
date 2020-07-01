package loja.api.dto;
import loja.api.model.entity.Administrador;
import loja.api.model.enums.TipoUsuario;
import lombok.*;


@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdministradorDto {

    private String ultimoAjuste;


    private String nome;


    private String endereco;


    private String email;


    private String senha;


    private String sexo;


}