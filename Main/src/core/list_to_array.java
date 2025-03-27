package core;
import java.util.*;
public class list_to_array {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter integers separated by commas (e.g., 1,2,3,5,7,4):");
            String input = scanner.nextLine();

            // Split the input string by commas and store in a string array
            String[] inputArray = input.split(",");

            // Create an integer array of the same size
            int[] numbers = new int[inputArray.length];

            // Convert each string element to an integer and store in the integer array
            for (int i = 0; i < inputArray.length; i++) {
                numbers[i] = Integer.parseInt(inputArray[i].trim()); // Trim to remove extra spaces
            }
            System.out.println("The created 1D array is:");
            for (int num : numbers) {
                System.out.print(STR."\{num} ");
            }

            scanner.close();
        }
}
