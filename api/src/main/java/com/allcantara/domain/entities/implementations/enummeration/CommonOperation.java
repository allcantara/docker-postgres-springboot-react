package com.allcantara.domain.entities.implementations.enummeration;

import com.allcantara.domain.entities.IOperation;

public class CommonOperation implements IOperation {
    private Long amountTransaction;
    private String storeName;
    private String ownerName;
    private Double accountBalance;

    public CommonOperation() {
    }

    public CommonOperation(Long amountTransaction, String storeName, String ownerName, Double accountBalance) {
        this.amountTransaction = amountTransaction;
        this.storeName = storeName;
        this.ownerName = ownerName;
        this.accountBalance = accountBalance;
    }

    public CommonOperation(IOperation operation) {
        this.amountTransaction = operation.getAmountTransaction();
        this.storeName = operation.getStoreName();
        this.ownerName = operation.getOwnerName();
        this.accountBalance = operation.getAccountBalance();
    }

    public Long getAmountTransaction() {
        return amountTransaction;
    }

    public void setAmountTransaction(Long amountTransaction) {
        this.amountTransaction = amountTransaction;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

}
