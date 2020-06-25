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
@Entity(name = "tb_administrador")
@PrimaryKeyJoinColumn(name="idPessoa")
public class Administrador extends Usuario {

    @Column(name = "ultimo_ajuste")
    private String ultimoAjuste;



}