package com.allcantara.domain.factory.implementations;

import java.util.ArrayList;
import java.util.List;

import com.allcantara.domain.entities.IOperation;
import com.allcantara.domain.entities.implementations.enummeration.CommonOperation;
import com.allcantara.domain.factory.IOperationFactory;

public class CommonOperationFactory implements IOperationFactory {


    @Override
    public List<IOperation> findAmountOperationsByStore() {
        List<IOperation> operations = new ArrayList<>();
        operations.add(new CommonOperation(4l, "Loja da esquina", "Bruno", 40.5));

        return operations;
    }
}
