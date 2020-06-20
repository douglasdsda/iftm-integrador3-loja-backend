package loja.api.model.repository;

import loja.api.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


        boolean existsByUserName(String userName);

        Optional<User> findByUserName(String userName);


        }