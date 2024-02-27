package za.co.shoprite.changecalculation.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.shoprite.changecalculation.enums.Denomination;
import za.co.shoprite.changecalculation.model.TransactionChangeInNotesAndCoins;
import za.co.shoprite.changecalculation.model.Transaction;
import za.co.shoprite.changecalculation.repository.TransactionRepository;
import za.co.shoprite.changecalculation.utils.Utils;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class ChangeCalculationService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public ChangeCalculationService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void calculateChange() {
        BigDecimal sellingPrice = Utils.generateRandomInRange(BigDecimal.ONE, new BigDecimal("100"));
        BigDecimal paymentValue = sellingPrice.add(Utils.generateRandomInRange(BigDecimal.ONE, new BigDecimal("100")));

        calculateChange(sellingPrice, paymentValue);
    }

    public void calculateChange(BigDecimal sellingPrice, BigDecimal paymentValue) {
        BigDecimal change = Utils.calculateChange(sellingPrice, paymentValue);

        log.info("Selling price: {}", sellingPrice);
        log.info("Payment value: {}", paymentValue);
        log.info("Change: {}", change);

        Map<Denomination, Integer> denominationIntegerMap = Utils.generateMapOf(new BigDecimal(change.toString()));
        denominationIntegerMap.forEach((denomination, count) -> log.info("{}: {}", denomination.getDescription(), count));

        String uuid = UUID.randomUUID().toString();
        TransactionChangeInNotesAndCoins transactionChangeInNotesAndCoins = getTransactionChangeInNotesAndRands(denominationIntegerMap);
        transactionChangeInNotesAndCoins.setId(uuid);

        Transaction transaction = Transaction.builder()
                .id(uuid)
                .sellingPrice(sellingPrice)
                .paymentValue(paymentValue)
                .change(change)
                .transactionChangeInNotesAndCoins(transactionChangeInNotesAndCoins)
                .build();

        transactionRepository.save(transaction);
    }

    private TransactionChangeInNotesAndCoins getTransactionChangeInNotesAndRands(Map<Denomination, Integer> denominationIntegerMap) {
        TransactionChangeInNotesAndCoins denominationForChange = new TransactionChangeInNotesAndCoins();
        denominationIntegerMap.forEach((d, count) -> {
            switch (d) {
                case TWO_HUNDRED_RAND -> denominationForChange.setNumberOfTwoHundredRandNotes(count);
                case ONE_HUNDRED_RAND -> denominationForChange.setNumberOfOneHundredRandNotes(count);
                case FIFTY_RAND -> denominationForChange.setNumberOfFiftyRandNotes(count);
                case TWENTY_RAND -> denominationForChange.setNumberOfTwentyRandNotes(count);
                case TEN_RAND -> denominationForChange.setNumberOfTenRandNotes(count);
                case FIVE_RAND -> denominationForChange.setNumberOfFiveRandCoins(count);
                case TWO_RAND -> denominationForChange.setNumberOfTwoRandCoins(count);
                case ONE_RAND -> denominationForChange.setNumberOfOneRandCoins(count);
                case FIFTY_CENT -> denominationForChange.setNumberOfFiftyCentCoins(count);
                case TWENTY_CENT -> denominationForChange.setNumberOfTwentyCentCoins(count);
                case TEN_CENT -> denominationForChange.setNumberOfTenCentCoins(count);
                case FIVE_CENT -> denominationForChange.setNumberOfFiveCentCoins(count);
                case ONE_CENT -> denominationForChange.setNumberOfOneCentCoins(count);
            }
        });
        return denominationForChange;
    }
}