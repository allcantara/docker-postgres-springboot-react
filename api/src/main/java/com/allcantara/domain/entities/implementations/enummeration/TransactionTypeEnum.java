package com.allcantara.domain.entities.implementations.enummeration;

import java.util.Arrays;

public enum TransactionTypeEnum {

    DEBIT("Débito", "Entrada", "+"),
    TICKET("Boleto", "Saída", "-"),
    FINANCING("Financiamento", "Saída", "-"),
    CREDIT("Crédito", "Entrada", "+"),
    LENDING("Recebimento Empréstimo", "Entrada", "+"),
    SALES("Vendas", "Entrada", "+"),
    TED("Recebimento TED", "Entrada", "+"),
    DOC("Recebimento DOC", "Entrada", "+"),
    RENT("Aluguel", "Saída", "-");

    private final String description;
    private final String nature;
    private final String signal;

    TransactionTypeEnum(String description, String nature, String signal) {
        this.description = description;
        this.nature = nature;
        this.signal = signal;
    }

    public Integer getType() {
        return this.ordinal();
    }

    public String getDescription() {
        return this.description;
    }

    public String getNature() {
        return this.description;
    }

    public String getSignal() {
        return this.description;
    }

    public static TransactionTypeEnum getByIndex(Integer index) {
        return Arrays.stream(TransactionTypeEnum.values()).toList().get(index - 1);
    }
}
