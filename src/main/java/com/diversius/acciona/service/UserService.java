package com.diversius.acciona.service;

import com.diversius.acciona.entity.User;

public interface UserService {

    void save(User user);

    User createUser(String userId, String name);

    User getUserByTwitterId(String twitterId);

    User getUserByHash(String hash);

    User getUserByHashOrException(String hash);

}
