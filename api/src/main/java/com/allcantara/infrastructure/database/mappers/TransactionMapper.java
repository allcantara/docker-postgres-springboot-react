package com.allcantara.infrastructure.database.mappers;

import com.allcantara.domain.entities.ITransaction;
import com.allcantara.domain.entities.implementations.enummeration.TransactionTypeEnum;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class TransactionMapper implements ITransaction {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, unique = true, nullable = false)
    private UUID id;

    private Date dateTime;
    private Double value;
    private String cpf;
    private String userCard;

    @Enumerated(EnumType.STRING)
    private TransactionTypeEnum type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    private StoreMapper store;
}
