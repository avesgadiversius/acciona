package com.diversius.acciona.service.impl;

import com.diversius.acciona.entity.User;
import com.diversius.acciona.repository.UserRepository;
import com.diversius.acciona.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User createUser(String userId, String name) {
        User user = new User(userId, name);
        save(user);

        return user;
    }

    @Override
    public User getUserByTwitterId(String twitterId) {
        return userRepository.findByTwitterIdAndDeletedFalse(twitterId);
    }

    @Override
    public User getUserByHash(String hash) {
        return userRepository.findByHashAndDeletedFalse(hash);
    }

    @Override
    public User getUserByHashOrException(String hash) {
        User user = getUserByHash(hash);
        if (user == null) {
            throw new EntityNotFoundException("User not found.");
        }

        return user;
    }
}
