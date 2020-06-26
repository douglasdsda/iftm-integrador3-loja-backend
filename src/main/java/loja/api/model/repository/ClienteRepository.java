package loja.api.model.repository;

import loja.api.model.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByCpf(String cpf);

    @Query("SELECT obj FROM Cliente obj where LOWER(obj.nome) LIKE LOWER(CONCAT('%',:nome, '%'))")
    Page<Cliente> findByNomeContainingIgnoreCase(@Param("nome") String nome, Pageable pageable);

    @Query("SELECT obj FROM Cliente obj ")
    List<Cliente> findByAll();
}