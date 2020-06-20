package loja.api.services;

import loja.api.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserServices {

    public User save(User user);

    Page<User> find(User filter, Pageable pageRequest);

}
