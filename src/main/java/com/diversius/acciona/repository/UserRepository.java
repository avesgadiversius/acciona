package com.diversius.acciona.repository;

import com.diversius.acciona.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByTwitterIdAndDeletedFalse(String twitterId);

    User findByHashAndDeletedFalse(String hash);

}
