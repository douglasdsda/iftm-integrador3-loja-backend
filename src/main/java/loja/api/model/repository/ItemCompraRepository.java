package loja.api.model.repository;

import loja.api.model.entity.Entregador;
import loja.api.model.entity.ItemCompra;
import loja.api.model.entity.pk.ItemCompraPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCompraRepository extends JpaRepository<ItemCompra, ItemCompraPK> {

}
