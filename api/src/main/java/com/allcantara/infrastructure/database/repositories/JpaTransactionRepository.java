package com.allcantara.infrastructure.database.repositories;

import com.allcantara.domain.entities.IOperation;
import com.allcantara.domain.factory.IOperationFactory;
import com.allcantara.domain.factory.ITransactionFactory;
import com.allcantara.infrastructure.database.mappers.TransactionMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Primary
@Repository
public interface JpaTransactionRepository extends JpaRepository<TransactionMapper, UUID>, ITransactionFactory, IOperationFactory {

    @Query(value = "SELECT " +
            "           COUNT(t) AS amountTransaction, " +
            "           s.name AS storeName, " +
            "           u.name AS ownerName, " +
            "           SUM(t.value) AS accountBalance " +
            "       FROM TransactionMapper t " +
            "           INNER JOIN t.store s " +
            "           INNER JOIN s.user u " +
            "       WHERE t.type IN ('DEBIT', 'CREDIT', 'LENDING', 'SALES', 'TED', 'DOC')" +
            "       GROUP BY s.name, u.name " +
            "       ORDER BY amountTransaction DESC ")
    List<IOperation> findAmountOperationsByStore();
}
