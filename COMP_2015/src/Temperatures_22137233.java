import java.util.Scanner;

public class Temperatures_22137233 {

    private static final Scanner scanner = new Scanner(System.in);

    private static final double INVALID_TEMP = -999.0f;
    private static final double MIN_TEMP = -10.0f;
    private static final double MAX_TEMP = 50.0f;

    private static final double FREEZING_THRESHOLD = 0.0f;
    private static final double COLD_THRESHOLD = 10.0f;
    private static final double MILD_THRESHOLD = 20.0f;
    private static final double WARM_THRESHOLD = 30.0f;
    private static final double HOT_THRESHOLD = 40.0f;

    private static void displayTemperatureStats(String rangeName, int count, double totalTemp, boolean hasData) {
        System.out.print(rangeName + ":\t\t" + count + " days");
        if (hasData) {
            System.out.printf("\tAverage Temperature: %.1f\n", totalTemp / count);
        } else {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter temperatures between " + MIN_TEMP + " and " + MAX_TEMP + ":");
        System.out.println("Enter " + INVALID_TEMP + " to finish.");

        int totalDays = 0;
        double freezingTotal = 0.0, coldTotal = 0.0, mildTotal = 0.0, warmTotal = 0.0, hotTotal = 0.0, extremeTotal = 0.0;
        int freezingCount = 0, coldCount = 0, mildCount = 0, warmCount = 0, hotCount = 0, extremeCount = 0;

        double temperature;
        while (true) {
            temperature = scanner.nextDouble();
            if (temperature == INVALID_TEMP) {
                System.out.println("Input terminated.");
                break;
            } else if (temperature < MIN_TEMP || temperature >= MAX_TEMP) {
                System.out.println("Temperature out of range. Ignored.");
            } else {
                totalDays++;
                if (temperature < FREEZING_THRESHOLD) {
                    freezingCount++;
                    freezingTotal += temperature;
                } else if (temperature < COLD_THRESHOLD) {
                    coldCount++;
                    coldTotal += temperature;
                } else if (temperature < MILD_THRESHOLD) {
                    mildCount++;
                    mildTotal += temperature;
                } else if (temperature < WARM_THRESHOLD) {
                    warmCount++;
                    warmTotal += temperature;
                } else if (temperature < HOT_THRESHOLD) {
                    hotCount++;
                    hotTotal += temperature;
                } else {
                    extremeCount++;
                    extremeTotal += temperature;
                }
                System.out.print("Next: ");
            }
        }

        if (totalDays == 0) {
            System.out.println("No temperatures recorded. No statistics available.");
        } else {
            displayTemperatureStats("Freezing", freezingCount, freezingTotal, freezingCount > 0);
            displayTemperatureStats("Cold", coldCount, coldTotal, coldCount > 0);
            displayTemperatureStats("Mild", mildCount, mildTotal, mildCount > 0);
            displayTemperatureStats("Warm", warmCount, warmTotal, warmCount > 0);
            displayTemperatureStats("Hot", hotCount, hotTotal, hotCount > 0);
            displayTemperatureStats("Extreme", extremeCount, extremeTotal, extremeCount > 0);
        }

        scanner.close();
    }
}