package com.diversius.acciona.builder.impl;

import com.diversius.acciona.builder.UserBuilder;
import com.diversius.acciona.dto.UserDTO;
import com.diversius.acciona.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserBuilderImpl implements UserBuilder {

    @Override
    public UserDTO convertToUserDTO(User user) {
        return new UserDTO(user);
    }

}
