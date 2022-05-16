package com.allcantara.useCases.transaction;

import com.allcantara.app.utils.exception.AllcantaraAppException;
import com.allcantara.domain.entities.ITransaction;

public class TransactionRules {

    public static void run(ITransaction entity) throws Exception {
        verifyCpfInvalid(entity.getCpf());
    }

    private static void verifyCpfInvalid(String cpf) throws Exception {
        int value = 0;

        value += Integer.valueOf(cpf.substring(0, 1)) * 10;
        value += Integer.valueOf(cpf.substring(1, 2)) * 9;
        value += Integer.valueOf(cpf.substring(2, 3)) * 8;
        value += Integer.valueOf(cpf.substring(3, 4)) * 7;
        value += Integer.valueOf(cpf.substring(4, 5)) * 6;
        value += Integer.valueOf(cpf.substring(5, 6)) * 5;
        value += Integer.valueOf(cpf.substring(6, 7)) * 4;
        value += Integer.valueOf(cpf.substring(7, 8)) * 3;
        value += Integer.valueOf(cpf.substring(8, 9)) * 2;

        int oneDigit = value % 10;

        value = 0;

        value += Integer.valueOf(cpf.substring(0, 1)) * 11;
        value += Integer.valueOf(cpf.substring(1, 2)) * 10;
        value += Integer.valueOf(cpf.substring(2, 3)) * 9;
        value += Integer.valueOf(cpf.substring(3, 4)) * 8;
        value += Integer.valueOf(cpf.substring(4, 5)) * 7;
        value += Integer.valueOf(cpf.substring(5, 6)) * 6;
        value += Integer.valueOf(cpf.substring(6, 7)) * 5;
        value += Integer.valueOf(cpf.substring(7, 8)) * 4;
        value += Integer.valueOf(cpf.substring(8, 9)) * 3;
        value += Integer.valueOf(cpf.substring(9, 10)) * 2;

        if (!String.valueOf(oneDigit).equals(cpf.substring(9)) && String.valueOf(oneDigit).equals(cpf.substring(10))) {
            throw new AllcantaraAppException("Cpf is invalid, please verify this information!");
        }

    }

}
