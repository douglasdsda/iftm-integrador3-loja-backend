package loja.api.model.repository;

import loja.api.model.entity.Categoria;
import loja.api.model.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query("SELECT obj FROM Categoria obj where LOWER(obj.nome) LIKE LOWER(CONCAT('%',:nome, '%'))")
    Page<Categoria> findByNomeContainingIgnoreCase(@Param("nome") String nome, Pageable pageable);

    @Query("SELECT obj FROM Categoria obj ")
    List<Categoria> findByAll();
}