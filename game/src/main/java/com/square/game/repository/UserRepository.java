package com.square.game.repository;

import com.square.game.controller.user.User;

import com.square.game.controller.user.UserCreationParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

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

}
