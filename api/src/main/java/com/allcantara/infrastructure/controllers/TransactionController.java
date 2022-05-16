package com.allcantara.infrastructure.controllers;

import com.allcantara.domain.entities.IOperation;
import com.allcantara.infrastructure.converter.TransactionConverter;
import com.allcantara.useCases.operation.ListOperationUseCase;
import com.allcantara.useCases.transaction.CreateTransactionUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@Api(tags = "Transaction")
public class TransactionController {
    private final CreateTransactionUseCase createTransactionUseCase;
    private final ListOperationUseCase listOperationUseCase;

    public TransactionController(CreateTransactionUseCase createTransactionUseCase, ListOperationUseCase listOperationUseCase) {
        this.createTransactionUseCase = createTransactionUseCase;
        this.listOperationUseCase = listOperationUseCase;
    }

    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    @ApiOperation(value = "Create a transaction using a text file.")
    public void create(@RequestParam(name = "file") MultipartFile multipartFile) throws Exception {
        TransactionConverter converter = new TransactionConverter();
        createTransactionUseCase.handler(converter.processCNABFile(multipartFile));
    }

    @GetMapping
    @Transactional(rollbackFor = Exception.class)
    @ApiOperation(value = "Search quantity of imported transactions by store.")
    public List<IOperation> create() throws Exception {
        return listOperationUseCase.handler();
    }

}
