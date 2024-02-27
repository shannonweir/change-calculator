package za.co.shoprite.changecalculation.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Table(name = "transaction_change_in_notes_and_coins")
public class TransactionChangeInNotesAndCoins {

    @Id
    private String id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Transaction transaction;

    private Integer numberOfTwoHundredRandNotes;
    private Integer numberOfOneHundredRandNotes;
    private Integer numberOfFiftyRandNotes;
    private Integer numberOfTwentyRandNotes;
    private Integer numberOfTenRandNotes;
    private Integer numberOfFiveRandCoins;
    private Integer numberOfTwoRandCoins;
    private Integer numberOfOneRandCoins;
    private Integer numberOfFiftyCentCoins;
    private Integer numberOfTwentyCentCoins;
    private Integer numberOfTenCentCoins;
    private Integer numberOfFiveCentCoins;
    private Integer numberOfOneCentCoins;


}
