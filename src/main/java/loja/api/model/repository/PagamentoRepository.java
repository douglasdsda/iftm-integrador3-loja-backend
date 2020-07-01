package loja.api.model.repository;

import loja.api.model.entity.Compra;
import loja.api.model.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {


    @Query("SELECT obj FROM Pagamento obj ")
    List<Pagamento> findByAll();
}