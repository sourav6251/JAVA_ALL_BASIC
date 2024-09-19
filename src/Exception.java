import java.io.IOException;

class Exception extends Throwable {

    // Method that declares it can throw IOException
    public static void readFile() throws IOException {
        throw new IOException("File not found");
    }

    public static void main(String[] args) {
        // Example of try...catch for ArrayIndexOutOfBoundsException
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);  // This will cause ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is out of bounds!");  // Handling the exception
        }

        // Example of try...catch for ArithmeticException with finally
        try {
            int result = 10 / 0;  // This will cause ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        } finally {
            System.out.println("This will always run.");  // The finally block
        }

        // Example of throwing an exception manually
        try {
            validateAge(15);  // This will throw an IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Example of a method that uses throws
        try {
            readFile();  // This will throw an IOException
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
    }

    // Method to throw an IllegalArgumentException manually
    public static void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above");
        }
        System.out.println("Age is valid.");
    }
}
