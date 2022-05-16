package com.allcantara.domain.entities.implementations;

import java.util.Date;
import java.util.UUID;

import com.allcantara.domain.entities.IStore;
import com.allcantara.domain.entities.ITransaction;
import com.allcantara.domain.entities.implementations.enummeration.TransactionTypeEnum;

public class CommonTransaction implements ITransaction {

    private UUID id;
    private Date dateTime;
    private Double value;
    private String cpf;
    private String userCard;
    private TransactionTypeEnum type;
    private IStore store;

    public CommonTransaction() {}

    public CommonTransaction(ITransaction transaction) {
        this.id = transaction.getId();
        this.dateTime = transaction.getDateTime();
        this.value = transaction.getValue();
        this.cpf = transaction.getCpf();
        this.userCard = transaction.getUserCard();
        this.type = transaction.getType();
        this.store = transaction.getStore();
    }

    public CommonTransaction(Date dateTime, Double value, String cpf, String userCard, TransactionTypeEnum type, IStore store) {
        this.dateTime = dateTime;
        this.value = value;
        this.cpf = cpf;
        this.userCard = userCard;
        this.type = type;
        this.store = store;
    }

    public CommonTransaction(UUID id, Date dateTime, Double value, String cpf, String userCard, TransactionTypeEnum type, IStore store) {
        this.id = id;
        this.dateTime = dateTime;
        this.value = value;
        this.cpf = cpf;
        this.userCard = userCard;
        this.type = type;
        this.store = store;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    public void setType(TransactionTypeEnum type) {
        this.type = type;
    }

    public void setStore(IStore store) {
        this.store = store;
    }

    public UUID getId() {
        return id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public Double getValue() {
        return value;
    }

    public String getCpf() {
        return cpf;
    }

    public String getUserCard() {
        return userCard;
    }

    public TransactionTypeEnum getType() {
        return type;
    }

    public IStore getStore() {
        return store;
    }

}
