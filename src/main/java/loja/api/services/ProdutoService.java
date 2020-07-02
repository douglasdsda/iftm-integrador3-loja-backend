package loja.api.services;

import loja.api.dto.CategoriaDto;
import loja.api.dto.ProdutoCategoriaDto;
import loja.api.dto.ProdutoDto;
import loja.api.exception.BusinessException;
import loja.api.model.entity.Categoria;
import loja.api.model.entity.Produto;
import loja.api.model.repository.CategoriaRepository;
import loja.api.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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


    public List<Produto> findByAll() {
        return repository.findByAll();
    }


    public ProdutoDto insert(ProdutoDto dto) {
        Produto entity = dto.toEntity();
        setCategorias(entity, dto.getCategorias());
        entity = repository.save(entity);
        return new ProdutoDto(entity);
    }

    private void setCategorias(Produto entity, List<CategoriaDto> categorias) {
        entity.getCategorias().clear();

        for (CategoriaDto dto : categorias) {
            Categoria category = categoriaRepository.getOne(dto.getIdCategoria());
            entity.getCategorias().add(category);
        }
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
