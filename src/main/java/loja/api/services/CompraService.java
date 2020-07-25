package loja.api.services;


import loja.api.dto.Item;
import loja.api.exception.BusinessException;
import loja.api.model.entity.Cliente;
import loja.api.model.entity.Compra;
import loja.api.model.entity.ItemCompra;
import loja.api.model.entity.Produto;
import loja.api.model.enums.StatusCompra;
import loja.api.model.repository.CompraRepository;
import loja.api.model.repository.ItemCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CompraService {

    @Autowired
    private CompraRepository repository;

    @Autowired
    private ItemCompraRepository itemCompraRepository;


    public Compra save(Compra entity, Long idCliente, List<ItemCompra> lista) {

        entity.setStatusCompra(StatusCompra.ESPERANDO);

        Cliente c = new Cliente();
        c.setIdUsuario(idCliente);
        entity.setCliente(c);



        Compra compra = repository.save(entity);

       lista.forEach( e -> {
           e.setCompra(compra);
       });

        itemCompraRepository.saveAll(lista);

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
