package loja.api.model.repository;

import loja.api.model.entity.Cliente;
import loja.api.model.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByCpf(String cpf);
}