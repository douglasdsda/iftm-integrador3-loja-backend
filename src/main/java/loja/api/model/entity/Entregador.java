package loja.api.model.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name="idUsuario")
public class Entregador extends Usuario {

    @Column(name = "disponivel")
    private boolean disponivel;

    @OneToMany(mappedBy = "id.entregador")
    private Set<Entrega> entregas = new HashSet<>();


    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }



    public Set<Entregador> getEntregas(){
        Set<Entregador> set = new HashSet<>();
        for(Entrega x : entregas) {
            set.add(x.getEntregador());
        }
        return set;
    }

}