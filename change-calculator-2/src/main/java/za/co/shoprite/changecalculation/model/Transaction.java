package za.co.shoprite.changecalculation.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    private String id;
    private BigDecimal sellingPrice;
    private BigDecimal paymentValue;
    private BigDecimal change;

    @OneToOne(mappedBy = "transaction", cascade = CascadeType.ALL)
    private TransactionChangeInNotesAndCoins transactionChangeInNotesAndCoins;

}
