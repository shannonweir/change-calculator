package za.co.shoprite.changecalculator;

import java.util.*;

public class Test {

    private static final Map<String, Integer> denominations = new LinkedHashMap<>();

    static {
        // Define denominations of South African notes and coins
        denominations.put("R200", 20000);
        denominations.put("R100", 10000);
        denominations.put("R50", 5000);
        denominations.put("R20", 2000);
        denominations.put("R10", 1000);
        denominations.put("R5", 500);
        denominations.put("R2", 200);
        denominations.put("R1", 100);
        denominations.put("50c", 50);
        denominations.put("20c", 20);
        denominations.put("10c", 10);
        denominations.put("5c", 5);
        denominations.put("1c", 1);
    }

    public static void main(String[] args) {
//        // Generate random sales price less than R100
//        double sellingPrice = generateRandomPrice(1, 9900) / 100.0;
//
//        // Generate random payment value greater than the selling price
//        double paymentValue = sellingPrice + generateRandomPrice(1, 100);

        double sellingPrice = 45.89;

        // Generate random payment value greater than the selling price
        double paymentValue = 120.43;

        System.out.printf("Selling Price: R%.2f%n", sellingPrice);
        System.out.printf("Payment Value: R%.2f%n", paymentValue);

        // Calculate change amount
        double changeAmount = (paymentValue - sellingPrice) * 100;

        // Calculate and print change denominations
        Map<String, Integer> changeDenominations = calculateChange(changeAmount);
        System.out.println("Change Denominations:");
        changeDenominations.forEach((denomination, count) -> System.out.println(denomination + ": " + count));
    }

    // Method to generate a random price within the specified range
    private static int generateRandomPrice(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    // Method to calculate change denominations
    private static Map<String, Integer> calculateChange(double amount) {
        Map<String, Integer> changeDenominations = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : denominations.entrySet()) {
            if (amount >= entry.getValue()) {
                int count = (int) (amount / entry.getValue());
                changeDenominations.put(entry.getKey(), count);
                amount -= count * entry.getValue();
            }
        }
        return changeDenominations;
    }
}
