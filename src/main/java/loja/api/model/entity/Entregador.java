package loja.api.model.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Entity
@PrimaryKeyJoinColumn(name="idUsuario")
public class Entregador extends Usuario {

    @Column(name = "disponivel")
    private boolean disponivel;

    @OneToMany( mappedBy = "id.entregador")
    private Set<Entrega> entregas = new HashSet<>();


    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Entregador(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Entregador(Long idUsuario, @NotNull String nome, @NotNull String endereco, String email, String senha, String sexo, boolean disponivel) {
        super(idUsuario, nome, endereco, email, senha, sexo);
        this.disponivel = disponivel;
    }
 /*
    public Set<Entregador> getEntregas(){
        Set<Entregador> set = new HashSet<>();
        for(Entrega x : entregas) {
            set.add(x.getEntregador());
        }
        return set;
    }
*/
}