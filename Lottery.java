
import java.util.Random;
import java.util.Scanner;

public class Lottery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int[] lottery = new int[5];
        int[] user = new int[5];

        // make five random lottery digits
        for (int i = 0; i < lottery.length; i++) {
            lottery[i] = random.nextInt(10);
        }

        // get the user's five digits
        for (int i = 0; i < user.length; i++) {
            user[i] = readDigit(scanner, i + 1);
        }

        // count digits that match in the same spot
        int matchingDigits = 0;
        for (int i = 0; i < lottery.length; i++) {
            if (lottery[i] == user[i]) {
                matchingDigits++;
            }
        }

        System.out.println();
        System.out.print("Lottery numbers: ");
        printDigits(lottery);
        System.out.print("Your numbers:    ");
        printDigits(user);
        System.out.println("Matching digits: " + matchingDigits);

        if (matchingDigits == lottery.length) {
            System.out.println("Congratulations! You are the grand-prize winner!");
        }
        scanner.close();
    }

    private static int readDigit(Scanner scanner, int position) {
        while (true) {
            System.out.print("Enter digit " + position + " (0-9): ");
            String input = scanner.nextLine().trim();
            if (input.matches("[0-9]")) {
                return Integer.parseInt(input);
            }
            System.out.println("Invalid digit. Please enter a number from 0 to 9.");
        }
    }

    private static void printDigits(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(digits[i]);
        }
        System.out.println();
    }
}
