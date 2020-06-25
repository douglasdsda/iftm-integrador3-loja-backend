package loja.api.services.impl;

import loja.api.dto.AdministradorDto;
import loja.api.model.entity.Administrador;
import loja.api.model.repository.AdministradorRepository;
import loja.api.services.AdministradorService;
import org.modelmapper.ModelMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Page<Administrador> find(String nome, Pageable pageRequest) {
           Page<Administrador> list;
           nome = nome == null ? nome : "";

           return repository.findByNomeContainingIgnoreCase(nome, pageRequest);

    }

    @Override
    public List<Administrador> findByAll() {
        return repository.findByAll();
    }

}
