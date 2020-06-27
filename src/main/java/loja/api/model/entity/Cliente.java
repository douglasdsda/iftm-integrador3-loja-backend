package loja.api.model.entity;


import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
@PrimaryKeyJoinColumn(name="idPessoa")
public class Cliente extends Usuario {

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "urlImagem")
    private String urlImagem;

    @Column(name = "ativo")
    private boolean ativo;

}