package loja.api.services.impl;

import loja.api.exception.BusinessException;
import loja.api.model.entity.Categoria;
import loja.api.model.entity.Categoria;
import loja.api.model.repository.CategoriaRepository;
import loja.api.model.repository.ClienteRepository;
import loja.api.services.CategoriaService;
import loja.api.services.ClienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private CategoriaRepository repository;

    public CategoriaServiceImpl(CategoriaRepository repository){
        this.repository = repository;
    }

    @Override
    public Categoria save(Categoria entity) {

        return repository.save(entity);
    }

    @Override
    public Page<Categoria> find(String nome, Pageable pageRequest) {
        Page<Categoria> list;
        nome = nome != null ? nome : "";

        return repository.findByNomeContainingIgnoreCase(nome, pageRequest);

    }

    @Override
    public List<Categoria> findByAll() {
        return repository.findByAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
