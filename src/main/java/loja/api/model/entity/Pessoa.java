package loja.api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance
@MappedSuperclass
public abstract class Pessoa {

    @Column(name = "nome")
    @NotNull
    private String nome;

    @Column(name = "endereco")
    @NotNull
    private String endereco;

}
