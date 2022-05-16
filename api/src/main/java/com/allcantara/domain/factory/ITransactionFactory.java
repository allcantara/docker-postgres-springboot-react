package com.allcantara.domain.factory;

import com.allcantara.domain.entities.ITransaction;

public interface ITransactionFactory {
    ITransaction save(ITransaction transaction);
}
