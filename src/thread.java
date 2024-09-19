import java.util.Random;

class RandomNumberGenerator extends Thread {
    public int count;
    private volatile int generatedNumber;
    private volatile boolean matched = false;
    private final int targetNumber;

    public RandomNumberGenerator(int targetNumber) {
        this.targetNumber = targetNumber;
    }

    public int getGeneratedNumber() {
        return generatedNumber;
    }

    public boolean isMatched() {
        return matched;
    }

    // Generate random numbers continuously
    public void run() {
        Random rand = new Random();
        while (!matched) {
            generatedNumber = rand.nextInt(1000);  // Generating random number between 0 and 99
            System.out.println("Generated Number: " + generatedNumber);
            count++;

            // Sleep for a short period to simulate time delay
            try {
                Thread.sleep(100);  // Sleep for 100 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Check if generated number matches the target number
    public void checkMatch() {
        if (generatedNumber == targetNumber) {
            matched = true;
            System.out.println("Match Found! Generated number is: " + generatedNumber);
            System.out.println(count);
        }
    }
}

public class thread{
    public static void main(String[] args) throws InterruptedException {
        int preFixedNumber = 50;  // Pre-fixed number to match
        RandomNumberGenerator generator = new RandomNumberGenerator(preFixedNumber);

        // Start the random number generator thread
        generator.start();

        // Continuously check if the generated number matches the pre-fixed number
        while (!generator.isMatched()) {
            generator.checkMatch();

            // Sleep for a short period before checking again
            Thread.sleep(100);  // Sleep for 100 milliseconds
        }

        System.out.println("Program finished.");
    }
}
