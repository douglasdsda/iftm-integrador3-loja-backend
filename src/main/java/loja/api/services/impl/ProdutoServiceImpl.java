package loja.api.services.impl;

import loja.api.dto.CategoriaDto;
import loja.api.dto.ProdutoCategoriaDto;
import loja.api.dto.ProdutoDto;
import loja.api.model.entity.Categoria;
import loja.api.model.entity.Produto;
import loja.api.model.entity.Produto;
import loja.api.model.repository.CategoriaRepository;
import loja.api.model.repository.ProdutoRepository;
import loja.api.services.CategoriaService;
import loja.api.services.ProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository repository;

    private CategoriaRepository categoriaRepository;

    public ProdutoServiceImpl(ProdutoRepository repository, CategoriaRepository categoriaRepository){
        this.repository = repository;
        this.categoriaRepository = categoriaRepository;
    }


    @Override
    public Produto save(Produto entity) {
        return repository.save(entity);
    }

    @Override
    public List<Produto> findByAll() {
        return repository.findByAll();
    }

    @Override
    public ProdutoDto insert(ProdutoCategoriaDto dto) {
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

}
