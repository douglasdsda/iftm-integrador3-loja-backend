package loja.api.services;


import loja.api.model.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService {

     Cliente save(Cliente user);

    Page<Cliente>find(String nome, Pageable pageRequest);

    List<Cliente> findByAll();

}
