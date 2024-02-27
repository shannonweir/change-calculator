package za.co.shoprite.changecalculator.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public final class ChangeCalculationUtils {

    private static final Map<String, BigDecimal> currencyToCentsMap = new LinkedHashMap<>();

    static {
        currencyToCentsMap.put("R200", new BigDecimal(20000));
        currencyToCentsMap.put("R100", new BigDecimal(10000));
        currencyToCentsMap.put("R50", new BigDecimal(5000));
        currencyToCentsMap.put("R20", new BigDecimal(2000));
        currencyToCentsMap.put("R10", new BigDecimal(1000));
        currencyToCentsMap.put("R5", new BigDecimal(500));
        currencyToCentsMap.put("R2", new BigDecimal(200));
        currencyToCentsMap.put("R1", new BigDecimal(100));
        currencyToCentsMap.put("50c", new BigDecimal(50));
        currencyToCentsMap.put("20c", new BigDecimal(20));
        currencyToCentsMap.put("10c", new BigDecimal(10));
        currencyToCentsMap.put("5c", new BigDecimal(5));
        currencyToCentsMap.put("1c", new BigDecimal(1));
    }

    public static BigDecimal generateRandomBigDecimalInRange(BigDecimal min, BigDecimal max) {
        Random random = new Random();
        BigDecimal range = max.subtract(min);
        BigDecimal scaled = range.multiply(new BigDecimal(random.nextDouble()));
        BigDecimal result = scaled.add(min);
        return result.setScale(2, RoundingMode.HALF_UP);
    }

    public static Map<String, Integer> calculateChange(BigDecimal amount) {
        Map<String, Integer> changeDenominations = new LinkedHashMap<>();
        for (Map.Entry<String, BigDecimal> entry : currencyToCentsMap.entrySet()) {
            if (amount.compareTo(entry.getValue()) >= 1) {
                int count = amount.divide(entry.getValue()).intValue();
                changeDenominations.put(entry.getKey(), count);
                amount = amount.min(new BigDecimal(count).multiply(entry.getValue()));
            }
        }
        return changeDenominations;
    }

}
