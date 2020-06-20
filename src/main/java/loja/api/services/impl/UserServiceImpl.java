package loja.api.services.impl;

import loja.api.exception.BusinessException;
import loja.api.model.entity.User;
import loja.api.model.repository.UserRepository;
import loja.api.services.UserServices;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServices {

    private UserRepository repository;

    public UserServiceImpl(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        if(repository.existsByUserName(user.getUserName())){
            throw new BusinessException(("Nome já cadastrado."));
        }
        return repository.save(user);
    }

    @Override
    public Page<User> find(User filter, Pageable pageRequest) {
        Example<User> example = Example.of(filter, ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withIgnoreNullValues()
                .withStringMatcher( ExampleMatcher.StringMatcher.CONTAINING)
        );
        return repository.findAll(example, pageRequest);
    }
}
