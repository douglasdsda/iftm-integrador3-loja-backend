package loja.api.services;


import loja.api.exception.BusinessException;
import loja.api.model.entity.Cliente;
import loja.api.model.entity.Compra;
import loja.api.model.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository repository;




    public Compra save(Compra entity) {

        return repository.save(entity);
    }


    public List<Compra> findByAll() {
        return repository.findByAll();
    }


    public void delete(Long id) {

        try {
            repository.deleteById(id);
        } catch (Exception e){
            throw new BusinessException(("Erro interno no servidor."));
        }

    }

}
