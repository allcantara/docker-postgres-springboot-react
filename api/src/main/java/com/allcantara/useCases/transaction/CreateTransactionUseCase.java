package com.allcantara.useCases.transaction;

import com.allcantara.domain.entities.ITransaction;
import com.allcantara.domain.factory.ITransactionFactory;

import java.util.List;

public class CreateTransactionUseCase {
    private final ITransactionFactory factory;

    public CreateTransactionUseCase(ITransactionFactory factory) {
        this.factory = factory;
    }

    public void handler(List<ITransaction> entities) throws Exception {
        entities.forEach(entity -> {
            try {
                create(entity);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public ITransaction create(ITransaction entity) throws Exception {
        TransactionRules.run(entity);
        return factory.save(entity);
    }

}
