package loja.api.model.repository;

import loja.api.model.entity.Pessoa;
import loja.api.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


}