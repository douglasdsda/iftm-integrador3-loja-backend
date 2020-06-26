package loja.api.services.impl;

import loja.api.exception.BusinessException;
import loja.api.model.entity.Administrador;
import loja.api.model.entity.Cliente;
import loja.api.model.repository.ClienteRepository;
import loja.api.services.ClienteService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository){
        this.repository = repository;
    }

    @Override
    public Cliente save(Cliente cliente) {
        if(repository.existsByCpf(cliente.getCpf())){
            throw new BusinessException(("cpf já cadastrado."));
        }
        return repository.save(cliente);
    }

    @Override
    public Page<Cliente> find(String nome, Pageable pageRequest) {
        Page<Cliente> list;
        nome = nome != null ? nome : "";

        return repository.findByNomeContainingIgnoreCase(nome, pageRequest);

    }

    @Override
    public List<Cliente> findByAll() {
        return repository.findByAll();
    }
 
}
