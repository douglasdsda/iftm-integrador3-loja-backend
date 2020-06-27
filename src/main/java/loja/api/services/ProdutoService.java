package loja.api.services;

import loja.api.dto.ProdutoCategoriaDto;
import loja.api.dto.ProdutoDto;
import loja.api.model.entity.Categoria;
import loja.api.model.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProdutoService {

    Produto save(Produto entity);

    List<Produto> findByAll();

    ProdutoDto insert(ProdutoCategoriaDto dto);
}
