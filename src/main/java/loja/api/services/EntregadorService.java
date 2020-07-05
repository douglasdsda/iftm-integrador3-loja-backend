package loja.api.services;

import loja.api.dto.EntregaDto;
import loja.api.exception.BusinessException;
import loja.api.model.entity.Administrador;
import loja.api.model.entity.Compra;
import loja.api.model.entity.Entrega;
import loja.api.model.entity.Entregador;
import loja.api.model.enums.StatusCompra;
import loja.api.model.enums.StatusEntrega;
import loja.api.model.repository.CompraRepository;
import loja.api.model.repository.EntregaRepository;
import loja.api.model.repository.EntregadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.time.Instant;
import java.util.List;
@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository repository;

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private EntregaRepository entregaRepository;

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

    public List<Entrega> findEntregas() {
        return entregaRepository.findAll();
    }

    public void entrega(EntregaDto dto) {
      Compra c =  compraRepository.findById(dto.getIdCompra()).orElse(null);
        Entregador e =  repository.findById(dto.getIdEntregador()).orElse(null);

        if (c == null){
           throw new BusinessException(("comprador invalido."));
        }

        if (e == null){
            throw new BusinessException(("entregador invalido."));
        }

         Entrega entrega = new Entrega();

        entrega.setCompra(c);
        entrega.setEntregador(e);
        entrega.setStatusEntrega(StatusEntrega.PREPARANDO);
        entrega.setData(Instant.now());

        entregaRepository.save(entrega);
    }
}
