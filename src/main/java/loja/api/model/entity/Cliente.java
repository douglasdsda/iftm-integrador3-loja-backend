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
@Entity(name = "tb_cliente")
public class Cliente extends Usuario {

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "urlImagem")
    private String urlImagem;

    @Column(name = "ativo")
    private boolean ativo;

}