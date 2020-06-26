package loja.api.services;

import loja.api.model.entity.Administrador;
import loja.api.model.entity.Entregador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EntregadorService {

    Entregador save(Entregador adm);

    Page<Entregador>find(String nome, Pageable pageRequest);

    List<Entregador> findByAll();

}
