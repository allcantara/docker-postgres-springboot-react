package com.allcantara.useCases;

import com.allcantara.domain.entities.ITransaction;
import com.allcantara.domain.entities.implementations.enummeration.TransactionTypeEnum;
import com.allcantara.domain.factory.implementations.CommonTransactionFactory;
import com.allcantara.infrastructure.converter.TransactionConverter;
import com.allcantara.useCases.transaction.CreateTransactionUseCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateTransactionUseCaseTest {
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(CreateTransactionUseCaseTest.class);

    @Test
    public void test() {
        try {
            LOG.info("Testing ===> CreateTransactionUseCase");
            CreateTransactionUseCase createUseCase = new CreateTransactionUseCase(new CommonTransactionFactory());
            TransactionConverter dto = new TransactionConverter("3201903010000010300232702980566777****1313172712JOSÉ COSTA    MERCEARIA 3 IRMÃOS");
            ITransaction transaction = createUseCase.create(dto.toEntity());

            assertEquals(TransactionTypeEnum.FINANCING, transaction.getType());
            assertEquals(103.0, transaction.getValue());
            assertEquals("23270298056", transaction.getCpf());
            assertEquals("6777****1313", transaction.getUserCard());
            assertEquals("Mon Apr 01 17:27:12 BRT 2019", transaction.getDateTime().toString());
            assertEquals("MERCEARIA 3 IRMÃOS", transaction.getStore().getName());
            assertEquals("JOSÉ COSTA", transaction.getStore().getUser().getName());

            LOG.info("Success Testing ===> CreateTransactionUseCase");
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

}
