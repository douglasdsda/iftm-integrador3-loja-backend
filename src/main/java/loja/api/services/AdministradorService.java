package loja.api.services;

import loja.api.model.entity.Administrador;
import loja.api.model.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdministradorService {

    public Administrador save(Administrador adm);

    Page<Administrador> find(Administrador filter, Pageable pageRequest);

}
