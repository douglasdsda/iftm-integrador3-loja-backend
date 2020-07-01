package loja.api.model.repository;

import loja.api.model.entity.Cliente;
import loja.api.model.entity.Compra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {


    @Query("SELECT obj FROM Cliente obj ")
    List<Compra> findByAll();
}