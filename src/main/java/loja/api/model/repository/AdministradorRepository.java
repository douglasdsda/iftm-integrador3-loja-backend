package loja.api.model.repository;

import loja.api.model.entity.Administrador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    @Transactional(readOnly = true)
    @Query("SELECT obj FROM loja.api.model.entity.Administrador obj where LOWER(obj.nome) LIKE LOWER(CONCAT('%',:nome, '%'))")
    Page<Administrador> findByNomeContainingIgnoreCase(@Param("nome") String nome, Pageable pageable);


    @Query("SELECT obj FROM loja.api.model.entity.Administrador obj ")
    List<Administrador> findByAll();

}