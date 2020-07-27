package loja.api.model.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name="idUsuario")
public class Administrador extends Usuario {

    @Column(name = "ultimo_ajuste")
    private String ultimoAjuste;
}