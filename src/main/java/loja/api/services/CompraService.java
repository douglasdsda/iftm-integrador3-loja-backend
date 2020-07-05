package loja.api.services;


import loja.api.dto.Item;
import loja.api.exception.BusinessException;
import loja.api.model.entity.Cliente;
import loja.api.model.entity.Compra;
import loja.api.model.entity.ItemCompra;
import loja.api.model.entity.Produto;
import loja.api.model.enums.StatusCompra;
import loja.api.model.repository.CompraRepository;
import loja.api.model.repository.ItemProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository repository;

    @Autowired
    private ItemProdutoRepository itemProdutoRepository;


    public Compra save(Compra entity, Long idCliente, List<Item> lista) {

        entity.setStatusCompra(StatusCompra.ESPERANDO);

        Cliente c = new Cliente();
        c.setIdUsuario(idCliente);
        entity.setCliente(c);

        Compra compra = repository.save(entity);

     List<ItemCompra> itensCompra = new ArrayList<>();
        for ( Item item: lista
             ) {
            ItemCompra itemCompra = new ItemCompra();
            itemCompra.setCompra(compra);
            itemCompra.setPreco(item.getPreco());
            itemCompra.setQuantidade(item.getQuantidade());
            itemCompra.setQuantidade(item.getQuantidade());
            Produto p = new Produto();
            p.setIdProduto(item.getIdProduto());

            itemCompra.setProduto(p);

            itensCompra.add(itemCompra);

        }
        itemProdutoRepository.saveAll(itensCompra);

        return compra;

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
