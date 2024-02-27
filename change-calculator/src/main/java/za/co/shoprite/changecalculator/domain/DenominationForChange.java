package za.co.shoprite.changecalculator.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Table(name = "rand_notes_and_coins")
public class ChangeInNotesAndCoins {

    @Id
    private String id;

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
