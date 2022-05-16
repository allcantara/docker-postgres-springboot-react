package com.allcantara.useCases.operation;

import com.allcantara.domain.entities.IOperation;
import com.allcantara.domain.factory.IOperationFactory;

import java.util.List;

public class ListOperationUseCase {
    private final IOperationFactory factory;

    public ListOperationUseCase(IOperationFactory factory) {
        this.factory = factory;
    }

    public List<IOperation> handler() {
        return factory.findAmountOperationsByStore();
    }
}
