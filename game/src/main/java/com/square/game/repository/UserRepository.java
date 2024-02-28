package com.square.game.repository;


import com.square.game.controller.user.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

}
