package com.allcantara.domain.factory;

import java.util.List;

import com.allcantara.domain.entities.IOperation;

public interface IOperationFactory {
    List<IOperation> findAmountOperationsByStore();
}
