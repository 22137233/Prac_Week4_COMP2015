import java.util.Scanner;

public class Rodents_22137233 {

    private static final int MIN_INITIAL_POPULATION = 300;
    private static final double MIN_GROWTH_RATE = 0.0;
    private static final int MIN_PREDICTION_YEARS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialPopulation = getPositiveInt("Enter the initial rodent population (minimum 300): ", scanner, MIN_INITIAL_POPULATION);
        double growthRate = getPositiveDouble("Enter the annual growth rate (minimum 0.0%): ", scanner, MIN_GROWTH_RATE);
        int predictionYears = getPositiveInt("Enter the number of years to predict (minimum 10): ", scanner, MIN_PREDICTION_YEARS);

        double currentPopulation = initialPopulation;

        System.out.println("\nYear\t\tPopulation");
        System.out.println("-------------------------");

        for (int year = 1; year <= predictionYears; year++) {
            currentPopulation += currentPopulation * growthRate / 100;
            System.out.printf("%d\t\t%.0f\n", year, currentPopulation);
        }

        scanner.close();
    }

    private static int getPositiveInt(String prompt, Scanner scanner, int min) {
        int value;
        do {
            System.out.print(prompt);
            value = scanner.nextInt();
        } while (value < min);
        return value;
    }

    private static double getPositiveDouble(String prompt, Scanner scanner, double min) {
        double value;
        do {
            System.out.print(prompt);
            value = scanner.nextDouble();
        } while (value < min);
        return value;
    }
}