package loja.api.model.repository;

import loja.api.model.entity.Administrador;
import loja.api.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {


}