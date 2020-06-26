package loja.api.model.repository;

import loja.api.model.entity.Administrador;
import loja.api.model.entity.Entregador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EntregadorRepository extends JpaRepository<Entregador, Long> {

    @Transactional(readOnly = true)
    @Query("SELECT obj FROM Entregador obj where LOWER(obj.nome) LIKE LOWER(CONCAT('%',:nome, '%'))")
    Page<Entregador> findByNomeContainingIgnoreCase(@Param("nome") String nome, Pageable pageable);


    @Query(value = "SELECT a FROM Entregador a ")
    List<Entregador> findByAll();

}