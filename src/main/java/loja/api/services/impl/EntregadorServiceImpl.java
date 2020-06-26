package loja.api.services.impl;

import loja.api.model.entity.Entregador;
import loja.api.model.repository.EntregadorRepository;
import loja.api.services.EntregadorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregadorServiceImpl implements EntregadorService {

    private EntregadorRepository repository;

    public EntregadorServiceImpl(EntregadorRepository repository){
        this.repository = repository;

    }

    @Override
    public Entregador save(Entregador entity) {

        return repository.save(entity);
    }

    @Override
    public Page<Entregador> find(String nome, Pageable pageRequest) {

           nome = nome != null ? nome : "";

           return repository.findByNomeContainingIgnoreCase(nome, pageRequest);

    }

    @Override
    public List<Entregador> findByAll() {
        return repository.findByAll();
    }

}
