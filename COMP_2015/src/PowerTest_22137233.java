import java.util.Scanner;

public class PowerTest_22137233 {

    private static final Scanner scanner = new Scanner(System.in);

    public static double calculatePower(int base, int exponent) {
        if (base == 0 && exponent == 0) {
            return Double.NaN;
        } else if (base == 0 && exponent < 0) {
            return Double.POSITIVE_INFINITY;
        } else {
            double result = 1.0;
            for (int i = 0; i < Math.abs(exponent); i++) {
                result *= base;
            }
            return exponent < 0 ? 1.0 / result : result;
        }
    }

    public static int getValidNumber(String prompt, int minimum) {
        int number;
        do {
            System.out.print(prompt);
            number = scanner.nextInt();
        } while (number < minimum);
        return number;
    }

    public static void main(String[] args) {
        int base = getValidNumber("Enter a base number (can be 0): ", Integer.MIN_VALUE);
        int exponent = getValidNumber("Enter an exponent: ", Integer.MIN_VALUE);

        double customPowerResult = calculatePower(base, exponent);
        double libraryPowerResult = Math.pow(base, exponent);

        System.out.println("\nCustom power method result:");
        System.out.printf("%d raised to the power of %d = %.2f\n", base, exponent, customPowerResult);
        System.out.println("Math.pow method result:");
        System.out.printf("%d raised to the power of %d = %.2f\n", base, exponent, libraryPowerResult);

        if (Double.isNaN(customPowerResult) && Double.isNaN(libraryPowerResult)) {
            System.out.println("Both results are indeterminate (0^0).");
        } else if (Double.isInfinite(customPowerResult) || Double.isInfinite(libraryPowerResult)) {
            System.out.println("One or both results are infinite due to 0 raised to a negative power.");
        } else if (Math.abs(customPowerResult - libraryPowerResult) < 0.001) {
            System.out.println("SUCCESS – Your power method seems to be working correctly.");
        } else {
            System.out.println("Mismatch detected. Check your power method implementation or try with different values.");
        }
    }
}