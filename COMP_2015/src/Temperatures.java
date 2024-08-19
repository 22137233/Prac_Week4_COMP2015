import java.util.Scanner;

public class Temperatures {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Displays statistics for a temperature range.
     *
     * @param rangeName - the name of the temperature range
     * @param dayCount - the number of days in this temperature range
     * @param totalTemperature - the total temperature for this range
     * @param hasData - indicates if there's data to display for this range (avoids N/A for empty ranges)
     */
    public static void displayTemperatureStats(String rangeName, int dayCount, float totalTemperature, boolean hasData) {
        System.out.print(rangeName + ":\t\t" + dayCount + " days");
        if (hasData) {
            System.out.println("\tAverage Temperature:\t" + (totalTemperature / dayCount));
        } else {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        final float TERMINATION_VALUE = -999.0f; // Value to end input
        final float MIN_TEMP = -10.0f; // Minimum temperature for categorization
        final float MAX_TEMP = 50.0f; // Maximum temperature for categorization

        // Maximum temperature for each range
        final float FREEZING_THRESHOLD = 0.0f;
        final float COLD_THRESHOLD = 10.0f;
        final float MILD_THRESHOLD = 20.0f;
        final float WARM_THRESHOLD = 30.0f;
        final float HOT_THRESHOLD = 40.0f;

        float temperature; // Current temperature input

        // Counters and totals for each temperature range
        int freezingCount = 0;
        int coldCount = 0;
        int mildCount = 0;
        int warmCount = 0;
        int hotCount = 0;
        int extremeCount = 0;

        float freezingTotal = 0.0f;
        float coldTotal = 0.0f;
        float mildTotal = 0.0f;
        float warmTotal = 0.0f;
        float hotTotal = 0.0f;
        float extremeTotal = 0.0f;

        // Prompt user for temperature inputs
        System.out.println("Enter temperatures between " + MIN_TEMP + " and " + MAX_TEMP + ":");
        System.out.println("Enter " + TERMINATION_VALUE + " to finish.");

        while (true) {
            temperature = scanner.nextFloat();
            if (temperature == TERMINATION_VALUE) {
                System.out.println("Input terminated.");
                break;
            } else if (temperature < MIN_TEMP || temperature >= MAX_TEMP) {
                System.out.println("Temperature out of range. Ignored.");
            } else {
                // Categorize temperature and update counts and totals
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

        // Display temperature statistics
        int totalDays = freezingCount + coldCount + mildCount + warmCount + hotCount + extremeCount;
        if (totalDays == 0) {
            System.out.println("No temperatures recorded. No statistics available.");
        } else {
            boolean hasFreezingData = freezingCount > 0;
            boolean hasColdData = coldCount > 0;
            boolean hasMildData = mildCount > 0;
            boolean hasWarmData = warmCount > 0;
            boolean hasHotData = hotCount > 0;
            boolean hasExtremeData = extremeCount > 0;

            displayTemperatureStats("Freezing", freezingCount, freezingTotal, hasFreezingData);
            displayTemperatureStats("Cold", coldCount, coldTotal, hasColdData);
            displayTemperatureStats("Mild", mildCount, mildTotal, hasMildData);
            displayTemperatureStats("Warm", warmCount, warmTotal, hasWarmData);
            displayTemperatureStats("Hot", hotCount, hotTotal, hasHotData);
            displayTemperatureStats("Extreme", extremeCount, extremeTotal, hasExtremeData);
        }
    }
}