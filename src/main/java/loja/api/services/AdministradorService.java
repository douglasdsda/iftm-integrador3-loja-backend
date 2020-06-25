package loja.api.services;

import loja.api.model.entity.Administrador;
import loja.api.model.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdministradorService {

    Administrador save(Administrador adm);

    Page<Administrador>find(String nome, Pageable pageRequest);

    List<Administrador> findByAll();

}
