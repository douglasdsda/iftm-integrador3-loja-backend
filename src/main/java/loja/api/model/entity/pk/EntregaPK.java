package loja.api.model.entity.pk;

import loja.api.model.entity.Compra;
import loja.api.model.entity.Entrega;
import loja.api.model.entity.Entregador;
import loja.api.model.entity.Produto;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Embeddable
public class EntregaPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "idCompra")
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Entregador entregador;

}
