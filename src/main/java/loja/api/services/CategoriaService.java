package loja.api.services;

import loja.api.exception.BusinessException;
import loja.api.model.entity.Administrador;
import loja.api.model.entity.Categoria;
import loja.api.model.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;




    public Categoria save(Categoria entity) {

        return repository.save(entity);
    }


    public Page<Categoria> find(String nome, Pageable pageRequest) {
        Page<Categoria> list;
        nome = nome != null ? nome : "";

        return repository.findByNomeContainingIgnoreCase(nome, pageRequest);

    }


    public List<Categoria> findByAll() {
        return repository.findByAll();
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

}
