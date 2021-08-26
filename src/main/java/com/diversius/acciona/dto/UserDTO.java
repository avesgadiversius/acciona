package com.diversius.acciona.dto;

import com.diversius.acciona.entity.User;

public class UserDTO {

    private String hash;
    private String twitterId;
    private String name;

    public UserDTO(User user) {
        this.hash = user.getHash();
        this.twitterId = user.getTwitterId();
        this.name = user.getName();
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
