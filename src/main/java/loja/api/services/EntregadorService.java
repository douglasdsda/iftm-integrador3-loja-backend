package loja.api.services;

import loja.api.exception.BusinessException;
import loja.api.model.entity.Administrador;
import loja.api.model.entity.Entregador;
import loja.api.model.repository.EntregadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.List;
@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository repository;

    public Entregador save(Entregador entity) {

        return repository.save(entity);
    }

    public Page<Entregador> find(String nome, Pageable pageRequest) {

        nome = nome != null ? nome : "";

        return repository.findByNomeContainingIgnoreCase(nome, pageRequest);

    }


    public void delete(Long id) {

        try {
            repository.deleteById(id);
        } catch (ConstraintViolationException e){
            throw new BusinessException(("Existe um produto usando esa categoria."));
        } catch (Exception e){
            throw new BusinessException(("Erro interno no servidor."));
        }

    }


    public List<Entregador> findByAll() {
        return repository.findByAll();
    }

}
