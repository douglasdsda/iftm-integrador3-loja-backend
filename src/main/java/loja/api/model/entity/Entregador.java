package loja.api.model.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
@PrimaryKeyJoinColumn(name="idUsuario")
public class Entregador extends Usuario {

    @Column(name = "disponivel")
    private boolean disponivel;



}