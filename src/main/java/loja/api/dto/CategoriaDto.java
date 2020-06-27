package loja.api.dto;
import loja.api.model.enums.TipoCategoria;
import lombok.*;


@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDto {

    private Long idCategoria;

    private String nome;

    private TipoCategoria tipoCategoria;

}