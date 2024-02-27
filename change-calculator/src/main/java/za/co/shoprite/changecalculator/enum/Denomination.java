import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum RandNotesAndCoins {

    TWO_HUNDRED_RAND("R 200.00", new BigDecimal(200), new BigDecimal(20000)),
    ONE_HUNDRED_RAND("R 100.00", new BigDecimal(100), new BigDecimal(10000)),
    FIFTY_RAND("R 50.00", new BigDecimal(50), new BigDecimal(5000)),
    TWENTY_RAND("R 20.00", new BigDecimal(20), new BigDecimal(2000)),
    TEN_RAND("R 10.00", new BigDecimal(10), new BigDecimal(1000)),
    FIVE_RAND("R 5.00", new BigDecimal(5), new BigDecimal(500)),
    TWO_RAND("R 2.00", new BigDecimal(2), new BigDecimal(200)),
    ONE_RAND("R 1.00", new BigDecimal(1), new BigDecimal(100)),
    FIFTY_CENT("R 0.50", new BigDecimal(0.50), new BigDecimal(50)),
    TWENTY_CENT("R 0.20", new BigDecimal(0.20), new BigDecimal(20)),
    TEN_CENT("R 0.10", new BigDecimal(0.10), new BigDecimal(10)),
    FIVE_CENT("R 0.05", new BigDecimal(0.05), new BigDecimal(5)),
    ONE_CENT("R 0.01", new BigDecimal(0.01), new BigDecimal(1));

    private String description;
    private BigDecimal amount;
    private BigDecimal amountInCents;
}