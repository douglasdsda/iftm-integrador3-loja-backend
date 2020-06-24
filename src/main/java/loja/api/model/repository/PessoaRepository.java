package loja.api.model.repository;

import loja.api.model.entity.Cliente;
import loja.api.model.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


}