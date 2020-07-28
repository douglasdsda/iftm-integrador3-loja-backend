package loja.api.model.repository;

import loja.api.model.entity.Entregador;
import loja.api.model.entity.ItemCompra;
import loja.api.model.entity.pk.ItemCompraPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemCompraRepository extends JpaRepository<ItemCompra, ItemCompraPK> {

    @Query("select a from ItemCompra a where a.id.compra.cliente.idUsuario = :idCliente")
    void findByCliente(Long idCliente);
}
