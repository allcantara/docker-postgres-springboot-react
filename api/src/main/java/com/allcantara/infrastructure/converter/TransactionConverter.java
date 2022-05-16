package com.allcantara.infrastructure.converter;

import com.allcantara.app.utils.exception.AllcantaraAppException;
import com.allcantara.domain.entities.IStore;
import com.allcantara.domain.entities.ITransaction;
import com.allcantara.domain.entities.implementations.CommonStore;
import com.allcantara.domain.entities.implementations.CommonUser;
import com.allcantara.domain.entities.implementations.enummeration.TransactionTypeEnum;
import com.allcantara.domain.entities.implementations.enummeration.UserEnum;
import com.allcantara.infrastructure.database.mappers.StoreMapper;
import com.allcantara.infrastructure.database.mappers.TransactionMapper;
import com.allcantara.infrastructure.database.mappers.UserMapper;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionConverter {

    private UUID id;
    private Date dateTime;
    private Double value;
    private String cpf;
    private String userCard;
    private TransactionTypeEnum type;
    private IStore store;

    public TransactionConverter(String line) throws Exception {
        this.normalize(line);
    }

    public List<ITransaction> processCNABFile(MultipartFile file) throws Exception {
        List<ITransaction> transactions = new ArrayList<>();

        InputStream inputStream = file.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line = bufferedReader.readLine();

        while (line != null) {
            TransactionConverter converter = new TransactionConverter(line);
            transactions.add(converter.toEntity());
            line = bufferedReader.readLine();
        }

        return transactions;
    }

    public TransactionConverter toDTO(ITransaction transaction) {
        return new TransactionConverter(transaction.getId(), this.getDateTime(), this.getValue(), this.getCpf(), this.getUserCard(), this.getType(), this.getStore());
    }

    public ITransaction toEntity() {
        return TransactionMapper.builder().dateTime(this.dateTime).cpf(this.cpf).value(this.value).userCard(this.userCard).type(this.type).store(StoreMapper.builder().name(this.store.getName()).user(UserMapper.builder().name(this.store.getUser().getName()).type(this.store.getUser().getType()).build()).build()).build();
    }

    public void verifyLineInvalid(String line) throws Exception {
        if (line == null || line.isEmpty() || line.length() != 80) {
            throw new AllcantaraAppException("Line is invalid, please verify!");
        }
    }

    public void normalize(String line) throws Exception {
        this.verifyLineInvalid(line);

        String type = extractValue(line, 0, 1);
        String date = extractValue(line, 1, 9);
        String value = extractValue(line, 9, 19);
        String cpf = extractValue(line, 19, 30);
        String userCard = extractValue(line, 30, 42);
        String time = extractValue(line, 42, 48);
        String ownerName = extractValue(line, 48, 62);
        String storeName = extractValue(line, 62, 80);

        this.type = TransactionTypeEnum.getByIndex(Integer.valueOf(type));
        this.value = Double.parseDouble(value) / 100;
        this.userCard = userCard;
        this.dateTime = getDateTime(date, time);

        this.cpf = cpf.trim();

        CommonUser user = new CommonUser(ownerName, UserEnum.OWNER);
        this.store = new CommonStore(storeName, user);
    }

    private Date getDateTime(String date, String time) {
        // 2019'03'01
        // 17'27'12
        Integer year = parseIntegerToString(extractValue(date, 0, 4));
        Integer month = parseIntegerToString(extractValue(date, 4, 6));
        Integer day = parseIntegerToString(extractValue(date, 6, 8));
        Integer hour = parseIntegerToString(extractValue(time, 0, 2));
        Integer minute = parseIntegerToString(extractValue(time, 2, 4));
        Integer second = parseIntegerToString(extractValue(time, 4, 6));

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, minute, second);

        return calendar.getTime();
    }

    private String extractValue(String line, Integer start, Integer end) {
        return line.substring(start, end);
    }

    private Integer parseIntegerToString(String value) {
        return Integer.parseInt(value);
    }


}
