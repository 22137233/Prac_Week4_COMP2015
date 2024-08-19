import java.util.Scanner;

public class Rodents{

  static Scanner input = new Scanner(System.in);

  public static int ensureMinimumInt(int value, int minValue) {
    while (value < minValue) {
      System.out.print("Invalid input. Please enter a value of at least " + minValue + ": ");
      value = input.nextInt();
    }
    return value;
  }

  public static float ensureMinimumFloat(float value, float minValue) {
    while (value < minValue) {
      System.out.print("Invalid input. Please enter a value of at least " + minValue + ": ");
      value = input.nextFloat();
    }
    return value;
  }
// variable for the population calculation 
  public static void main(String[] args) {
    final short MIN_POPULATION = 300; 
    final float MIN_GROWTH_RATE = 0.0f; 
    final short MIN_DURATION = 10;
    int initialPopulation; 
    float growthRate; 
    double currentPopulation; 
    short predictionYears; 
    
    // Prompt for and validate the initial population size
    System.out.print("Enter the initial population of rodents: ");
    initialPopulation = ensureMinimumInt(input.nextInt(), MIN_POPULATION);

    // Prompt for and validate the annual growth rate
    System.out.print("Enter the annual growth rate percentage (e.g., 50 for 50%): ");
    growthRate = ensureMinimumFloat(input.nextFloat(), MIN_GROWTH_RATE);

    // Prompt for and validate the number of years for the prediction
    System.out.print("Enter the number of years to predict the rodent population: ");
    predictionYears = (short) ensureMinimumInt(input.nextShort(), MIN_DURATION);

    // Calculate population forecast
    currentPopulation = initialPopulation;
    System.out.println("Year\t\tPopulation");
    System.out.println("-----------------------------");

    for (int year = 1; year <= predictionYears; year++) {
      currentPopulation += (currentPopulation * growthRate / 100);
      System.out.printf("%d\t\t%.0f\n", year, currentPopulation);
    }

    input.close();
  }
}
