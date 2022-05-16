package com.allcantara.domain.entities.implementations;

import java.util.UUID;

import com.allcantara.domain.entities.IStore;
import com.allcantara.domain.entities.IUser;

public class CommonStore implements IStore {
    private UUID id;
    private String name;
    private IUser user;

    public CommonStore() {}

    public CommonStore(IStore store) {
        this.id = store.getId();
        this.name = store.getName().trim();
        this.user = store.getUser();
    }

    public CommonStore(String name, IUser type) {
        this.name = name.trim();
        this.user = type;
    }

    public CommonStore(UUID id, String name, IUser type) {
        this.id = id;
        this.name = name.trim();
        this.user = type;
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

    public void setUser(IUser user) {
        this.user = user;
    }

    public IUser getUser() {
        return this.user;
    }
}
