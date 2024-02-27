package za.co.shoprite.changecalculator.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private BigDecimal sellingPrice;
    private BigDecimal paymentValue;
    private BigDecimal change;
//    @ManyToOne
//    @JoinColumn(name = "change_in_notes_and_coins")
//    private ChangeInNotesAndCoins changeInNotesAndCoins;
}
