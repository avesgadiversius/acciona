package com.diversius.acciona.controller.response.user;

import com.diversius.acciona.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserResponseBuilder {

    public static UserResponse getUserResponse(UserDTO user) {
        return new UserResponse(user);
    }

    public static List<UserResponse> getUserResponses(List<UserDTO> users) {
        List<UserResponse> userResponses = new ArrayList<>();
        for (UserDTO user : users) {
            userResponses.add(getUserResponse(user));
        }
        return userResponses;
    }

}
