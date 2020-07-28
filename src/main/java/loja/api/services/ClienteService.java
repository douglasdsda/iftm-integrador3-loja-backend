package loja.api.services;


import loja.api.dto.ClienteDto;
import loja.api.dto.LoginDto;
import loja.api.exception.BusinessException;
import loja.api.model.entity.Cliente;
import loja.api.model.entity.Produto;
import loja.api.model.repository.ClienteRepository;
import loja.api.model.repository.ItemCompraRepository;
import loja.api.services.exception.RegraNegocioException;
import loja.api.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.util.List;

@Service
public class ClienteService  {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ItemCompraRepository itemCompraRepository;


    public Cliente save(Cliente cliente) throws RegraNegocioException {

          if(cliente.getEmail().isEmpty()){
              throw new RegraNegocioException("Email vazio");
          }

        if(cliente.getCpf().isEmpty()){
            throw new RegraNegocioException("Cpf vazio");
        }

          Cliente c = repository.findByEmailOrCpf(cliente.getEmail(), cliente.getCpf());

        if(c != null){
            throw new RegraNegocioException("cpf ou email já existem.");
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

    @Transactional
    public Cliente login(LoginDto dto) throws ResourceNotFoundException {

        Cliente c = repository.findByEmail(dto.getEmail());
        if(c == null || !c.getSenha().equals(dto.getPassword())){
            throw new ResourceNotFoundException("senha ou email não invalidos.");
        }

        return c;

    }

    public Cliente compras(ClienteDto dto) {

        //itemCompraRepository.findByCliente(dto.getIdCliente());
        return null;
    }
}
