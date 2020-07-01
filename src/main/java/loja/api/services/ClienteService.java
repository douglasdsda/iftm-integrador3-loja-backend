package loja.api.services;


import loja.api.exception.BusinessException;
import loja.api.model.entity.Cliente;
import loja.api.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;




    public Cliente save(Cliente cliente) {
        if(repository.existsByCpf(cliente.getCpf())){
            throw new BusinessException(("cpf já cadastrado."));
        }
        return repository.save(cliente);
    }


    public Page<Cliente> find(String nome, Pageable pageRequest) {
        Page<Cliente> list;
        nome = nome != null ? nome : "";

        return repository.findByNomeContainingIgnoreCase(nome, pageRequest);

    }


    public List<Cliente> findByAll() {
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
