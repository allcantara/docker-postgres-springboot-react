package com.allcantara.domain.entities;

import java.util.UUID;

import com.allcantara.domain.entities.implementations.enummeration.UserEnum;

public interface IUser {
    UUID getId();

    String getName();

    UserEnum getType();
}
