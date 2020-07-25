package loja.api.services;

import loja.api.dto.ProdutoDto;
import loja.api.exception.BusinessException;
import loja.api.model.entity.Categoria;
import loja.api.model.entity.Produto;
import loja.api.model.repository.CategoriaRepository;
import loja.api.model.repository.ProdutoRepository;
import loja.api.services.exception.DatabaseException;
import loja.api.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.util.List;
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto save(Produto entity) {
        return repository.save(entity);
    }

    @Transactional(readOnly = true)
    public List<Produto> findByAll() {
        return repository.findByAll();
    }

    @Transactional
    public ProdutoDto insert(ProdutoDto dto) {
        Produto entity = dto.toEntity();
        setCategoria(entity, dto.getCategoria());
        entity = repository.save(entity);
        return new ProdutoDto(entity);
    }

    private void setCategoria(Produto entity, Categoria categoria) {
        entity.setCategoria(categoria);
    }

    @Transactional
    public Produto update( Produto newEntity,Long id) {
        try {
            Produto entity = repository.getOne(id);
            updateData(entity, newEntity);
            entity = repository.save(entity);
            return entity;
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Produto entity, Produto newCategoria) {
        entity.setCategoria(newCategoria.getCategoria());
        entity.setDescricao(newCategoria.getDescricao());
        entity.setNome(newCategoria.getNome());
        entity.setPreco(newCategoria.getPreco());
        entity.setQtdEstoque(entity.getQtdEstoque());
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
