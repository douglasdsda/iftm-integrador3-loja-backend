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
@PrimaryKeyJoinColumn(name="idUsuario")
public class Administrador extends Usuario {

    @Column(name = "ultimo_ajuste")
    private String ultimoAjuste;



}