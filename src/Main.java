import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================================================");
        System.out.println("          BALANCED STRING ALGORITHMS - COMPARISON & DEMO              ");
        System.out.println("======================================================================");
        System.out.println(" Project Idea: Find the length of the longest balanced substring.");
        System.out.println(" Balanced Definition: Exactly TWO distinct characters, equal frequencies.");
        System.out.println("======================================================================\n");


        while (true) {

            System.out.print("Enter a custom string to test (or type 'exit' to quit): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            if (input.isEmpty()) {
                System.out.println("Please enter a valid non-empty string.\n");
                continue;
            }

            if (!input.matches("[a-zA-Z]+")) {
                System.out.println("Invalid input! Please enter a string containing only letters.\n");
                continue;
            }

            input = input.toLowerCase();

            long start1 = System.nanoTime();
            String sub1 = BalancedStringBruteForce.longestBalancedSubstring(input);
            long end1 = System.nanoTime();

            long start2 = System.nanoTime();
            String sub2 = BalancedStringBacktracking.longestBalancedSubstring(input);
            long end2 = System.nanoTime();

            System.out.println("\n--- Interactive Results ---");

            System.out.printf(
                    " [Algo 1 - Iterative] Substring: %s | Length: %d | Time: %.4f ms%n",
                    sub1.isEmpty() ? "None" : sub1,
                    sub1.length(),
                    (end1 - start1) / 1_000_000.0
            );

            System.out.printf(
                    " [Algo 2 - Recursive] Substring: %s | Length: %d | Time: %.4f ms%n",
                    sub2.isEmpty() ? "None" : sub2,
                    sub2.length(),
                    (end2 - start2) / 1_000_000.0
            );

            System.out.println("---------------------------\n");
        }

        System.out.println("Thank you! Project validation successfully finished.");

        scanner.close();
    }
}