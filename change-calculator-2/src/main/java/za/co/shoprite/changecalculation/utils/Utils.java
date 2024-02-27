package za.co.shoprite.changecalculation.utils;

import za.co.shoprite.changecalculation.enums.Denomination;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.Map;
import java.util.Random;

public final class Utils {

    public static BigDecimal generateRandomInRange(final BigDecimal min, final BigDecimal max) {
        Random random = new Random();
        BigDecimal range = max.subtract(min);
        BigDecimal scaled = range.multiply(new BigDecimal(random.nextDouble()));
        BigDecimal result = scaled.add(min);
        return result.setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal calculateChange(BigDecimal sellingPrice, BigDecimal paymentValue) {
        return paymentValue.subtract(sellingPrice);
    }

    public static Map<Denomination, Integer> generateMapOf(BigDecimal changeAmount) {
        BigDecimal changeAmountInCents = changeAmount.multiply(new BigDecimal("100"));
        Map<Denomination, Integer> changeDenominations = new EnumMap<>(Denomination.class);

        for (Denomination denomination : Denomination.values()) {
            BigDecimal amount = changeAmountInCents;
            if (amount.compareTo(denomination.getCentsValue()) >= 0) {
                int count = amount.divide(denomination.getCentsValue(), BigDecimal.ROUND_DOWN).intValue();
                changeDenominations.put(denomination, count);
                changeAmountInCents = changeAmountInCents.subtract(denomination.getCentsValue().multiply(BigDecimal.valueOf(count)));
            }
        }
        return changeDenominations;
    }
}
