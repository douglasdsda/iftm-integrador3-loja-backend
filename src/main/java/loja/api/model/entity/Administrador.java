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
@DiscriminatorValue("administrador")
@Entity(name = "tb_administrador")
public class Administrador extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_administrador")
    private Long id;

    @Column(name = "ultimo_ajuste")
    private String ultimoAjuste;

}