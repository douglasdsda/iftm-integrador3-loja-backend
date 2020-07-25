package loja.api.services;

import loja.api.exception.BusinessException;
import loja.api.model.entity.Administrador;
import loja.api.model.entity.Categoria;
import loja.api.model.repository.CategoriaRepository;
import loja.api.services.exception.DatabaseException;
import loja.api.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;



    @Transactional
    public Categoria save(Categoria entity) {

        return repository.save(entity);
    }

    @Transactional
    public Categoria update( Categoria categoria,Long id) {
        try {
            Categoria entity = repository.getOne(id);
            updateData(entity, categoria);
            entity = repository.save(entity);
            return entity;
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Categoria entity, Categoria newCategoria) {
        entity.setNome(newCategoria.getNome());
        entity.setTipoCategoria(newCategoria.getTipoCategoria());
    }

    @Transactional(readOnly = true)
    public Page<Categoria> find(String nome, Pageable pageRequest) {
        Page<Categoria> list;
        nome = nome != null ? nome : "";

        return repository.findByNomeContainingIgnoreCase(nome, pageRequest);
    }

    @Transactional(readOnly = true)
    public List<Categoria> findByAll() {
        return repository.findByAll();
    }


    @Transactional
    public void delete(Long id) {

        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

}
