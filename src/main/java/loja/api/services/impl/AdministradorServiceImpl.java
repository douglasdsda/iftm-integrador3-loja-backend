package loja.api.services.impl;

import loja.api.exception.BusinessException;
import loja.api.model.entity.Administrador;
import loja.api.model.entity.Cliente;
import loja.api.model.repository.AdministradorRepository;
import loja.api.model.repository.ClienteRepository;
import loja.api.services.AdministradorService;
import loja.api.services.ClienteService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdministradorServiceImpl implements AdministradorService {

    private AdministradorRepository repository;

    public AdministradorServiceImpl(AdministradorRepository repository){
        this.repository = repository;
    }

    @Override
    public Administrador save(Administrador entity) {

        return repository.save(entity);
    }

    @Override
    public Page<Administrador> find(Administrador filter, Pageable pageRequest) {
        Example<Administrador> example = Example.of(filter, ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withIgnoreNullValues()
                .withStringMatcher( ExampleMatcher.StringMatcher.CONTAINING)
        );
        return repository.findAll(example, pageRequest);
    }
 
}
