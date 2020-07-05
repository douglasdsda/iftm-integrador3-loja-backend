package loja.api.services;


import loja.api.exception.BusinessException;
import loja.api.model.entity.Cliente;
import loja.api.model.entity.Compra;
import loja.api.model.entity.Pagamento;
import loja.api.model.enums.StatusCompra;
import loja.api.model.repository.CompraRepository;
import loja.api.model.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    @Autowired
    private CompraRepository compraRepository;

    public Pagamento save(Long idCompra) {

        Compra compra = compraRepository.getOne(idCompra);

        if(compra == null){
            throw new BusinessException(("Compra invalida."));
        }
        Pagamento pagamento = new Pagamento(null, compra);
        pagamento.setData(Instant.now());
        compra.setStatusCompra(StatusCompra.PAGO);
        compra.setPagamento(pagamento);

      compra = compraRepository.save(compra);

        return compra.getPagamento();
    }




    public List<Pagamento> findByAll() {
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
