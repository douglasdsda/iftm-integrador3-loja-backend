package loja.api.dto;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Item {

    private Integer quantidade;

    private Double preco;

    private Long idProduto;

}
