package com.square.game.repository;

import com.square.game.controller.product.Product;
import com.square.game.controller.user.User;

import com.square.game.controller.user.UserCreationParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.UUID;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    default User updateUserForRepoImpl(UUID userId, UserCreationParam param){
        User user = getReferenceById(userId);
        user.setId(userId);
        user.setFirstName(param.getFirstName());
        user.setLastName(param.getLastName());
        user.setAge(param.getAge());
        save(user);
        return user;
    }

    @Query(" select u from Product u " +
            " where u.username = ?1")
    Optional<User> findByUsername(String username);


}
