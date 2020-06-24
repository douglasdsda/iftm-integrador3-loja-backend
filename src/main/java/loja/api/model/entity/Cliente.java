package loja.api.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("cliente")
@Entity(name = "tb_cliente")
public class Cliente extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "urlImagem")
    private String urlImagem;

    @Column(name = "ativo")
    private boolean ativo;

}