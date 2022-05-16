package com.allcantara.domain.entities.implementations;

import java.util.UUID;

import com.allcantara.domain.entities.IUser;
import com.allcantara.domain.entities.implementations.enummeration.UserEnum;

public class CommonUser implements IUser {
    private UUID id;
    private String name;
    private UserEnum type;

    public CommonUser() {
    }

    public CommonUser(IUser user) {
        this.id = user.getId();
        this.name = user.getName().trim();
        this.type = user.getType();
    }

    public CommonUser(String name, UserEnum type) {
        this.name = name.trim();
        this.type = type;
    }

    public CommonUser(UUID id, String name, UserEnum type) {
        this.id = id;
        this.name = name.trim();
        this.type = type;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setType(UserEnum type) {
        this.type = type;
    }

    public UserEnum getType() {
        return this.type;
    }
}
