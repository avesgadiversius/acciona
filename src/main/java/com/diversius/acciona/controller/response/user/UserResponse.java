package com.diversius.acciona.controller.response.user;

import com.diversius.acciona.dto.UserDTO;

import static java.util.Objects.nonNull;

public class UserResponse {

    private String hash;
    private String twitterId;
    private String name;

    public UserResponse(UserDTO user) {
        if (nonNull(user)) {
            this.hash = user.getHash();
            this.twitterId = user.getTwitterId();
            this.name = user.getName();
        }
    }

    public String getHash() {
        return hash;
    }

    public String getTwitterId() {
        return twitterId;
    }

    public String getName() {
        return name;
    }

}
