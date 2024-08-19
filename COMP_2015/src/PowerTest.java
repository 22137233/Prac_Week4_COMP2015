import java.util.Scanner;

public class PowerTest {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Computes the power of a base number raised to a given exponent, handling negative exponents gracefully.
     *
     * @param base - the base number
     * @param exponent - the exponent to raise the base number to
     * @return the result of base^exponent, or Double.NaN for invalid inputs
     */
    public static double power(int base, int exponent) {
        if (base == 0 && exponent == 0) {
            // Indeterminate form 0^0 is handled as Double.NaN
            return Double.NaN;
        } else if (base == 0 && exponent < 0) {
            // 0 raised to a negative power is undefined
            return Double.POSITIVE_INFINITY; // Or throw an IllegalArgumentException
        } else {
            double result = 1;
            for (int i = 0; i < Math.abs(exponent); i++) {
                result *= base;
            }
            // Handle negative exponents by reciprocating
            return exponent < 0 ? 1.0 / result : result;
        }
    }

    /**
     * Validates that the input number is at least the minimum value.
     *
     * @param number - the number to validate
     * @param minimum - the minimum acceptable value
     * @return a valid number that is at least the minimum value
     */
    public static int validateInput(int number, int minimum) {
        while (number < minimum) {
            System.out.print("Invalid input. The number must be at least " + minimum + ". Please try again: ");
            number = scanner.nextInt();
        }
        return number;
    }

    public static void main(String[] args) {
        int base;
        int exponent;

        System.out.print("Enter a base number: ");
        base = validateInput(scanner.nextInt(), 0);

        System.out.print("Enter an exponent: ");
        exponent = validateInput(scanner.nextInt(), Integer.MIN_VALUE); // Allow negative exponents

        double customPowerResult = power(base, exponent);
        double libraryPowerResult = Math.pow(base, exponent);

        System.out.println("\nCustom power method result: " + base + " raised to the power of " + exponent
                + " = " + customPowerResult);
        System.out.println("Math.pow method result: " + base + " raised to the power of " + exponent
                + " = " + libraryPowerResult);

        if (Double.isNaN(customPowerResult) && Double.isNaN(libraryPowerResult)) {
            System.out.println("Both results are indeterminate (0^0).");
        } else if (Double.isInfinite(customPowerResult) || Double.isInfinite(libraryPowerResult)) {
            System.out.println("One or both results are infinite due to 0 raised to a negative power.");
        } else if (customPowerResult == libraryPowerResult) {
            System.out.println("SUCCESS – Your power method seems to be working correctly.");
        } else {
            System.out.println("Mismatch detected. Check your power method implementation or try with different values.");
        }
    }
}