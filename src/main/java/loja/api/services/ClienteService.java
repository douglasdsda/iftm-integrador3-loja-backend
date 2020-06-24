package loja.api.services;

import loja.api.model.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteService {

    public Cliente save(Cliente user);

    Page<Cliente> find(Cliente filter, Pageable pageRequest);

}
