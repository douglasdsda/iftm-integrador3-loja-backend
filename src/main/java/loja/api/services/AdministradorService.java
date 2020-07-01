package loja.api.services;

import loja.api.model.entity.Administrador;
import loja.api.model.entity.Cliente;
import loja.api.model.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository repository;



    public Administrador save(Administrador entity) {

        return repository.save(entity);
    }


    public Page<Administrador> find(String nome, Pageable pageRequest) {

        nome = nome != null ? nome : "";

        return repository.findByNomeContainingIgnoreCase(nome, pageRequest);

    }


    public List<Administrador> findByAll() {
        return repository.findByAll();
    }


    public void delete(Long id) {

        try {
            repository.deleteById(id);
        } catch (Exception e){
            System.err.print(e);
        }

    }

}
