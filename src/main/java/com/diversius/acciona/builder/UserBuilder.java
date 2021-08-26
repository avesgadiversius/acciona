package com.diversius.acciona.builder;

import com.diversius.acciona.dto.UserDTO;
import com.diversius.acciona.entity.User;

public interface UserBuilder {

    UserDTO convertToUserDTO(User user);

}
