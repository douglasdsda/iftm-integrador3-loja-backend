package loja.api.dto;
import lombok.*;


@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorDto {

    private boolean disponivel;


    private String nome;


    private String endereco;


    private String email;


    private String senha;



    private String sexo;


}