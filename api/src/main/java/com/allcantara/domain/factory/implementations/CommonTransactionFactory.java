package com.allcantara.domain.factory.implementations;

import com.allcantara.domain.entities.ITransaction;
import com.allcantara.domain.entities.implementations.CommonTransaction;
import com.allcantara.domain.factory.ITransactionFactory;

public class CommonTransactionFactory implements ITransactionFactory {

    @Override
    public ITransaction save(ITransaction transaction) {
        return new CommonTransaction(transaction);
    }

}
