package loja.api.services;

import loja.api.model.entity.Administrador;
import loja.api.model.entity.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoriaService {

    Categoria save(Categoria entity);

    Page<Categoria>find(String nome, Pageable pageRequest);

    List<Categoria> findByAll();

}
