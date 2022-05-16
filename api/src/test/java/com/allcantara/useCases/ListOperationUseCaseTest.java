package com.allcantara.useCases;

import com.allcantara.domain.entities.IOperation;
import com.allcantara.domain.factory.implementations.CommonOperationFactory;
import com.allcantara.useCases.operation.ListOperationUseCase;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListOperationUseCaseTest {
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(ListOperationUseCaseTest.class);

    @Test
    public void test() {
        try {
            LOG.info("Testing ===> ListOperationUseCaseTest");
            ListOperationUseCase listUseCase = new ListOperationUseCase(new CommonOperationFactory());
            List<IOperation> operations = listUseCase.handler();
            IOperation operation = operations.get(0);

            assertEquals(4l, operation.getAmountTransaction());
            assertEquals("Loja da esquina", operation.getStoreName());
            assertEquals("Bruno", operation.getOwnerName());
            assertEquals(40.5, operation.getAccountBalance());

            LOG.info("Success Testing ===> ListOperationUseCaseTest");
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

}
