package loja.api.model.repository;

import loja.api.model.entity.Compra;
import loja.api.model.entity.Entrega;
import loja.api.model.entity.Entregador;
import loja.api.model.entity.pk.EntregaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EntregaRepository extends JpaRepository<Entrega, EntregaPK> {



}