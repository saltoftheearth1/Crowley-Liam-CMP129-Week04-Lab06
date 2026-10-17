
import java.util.Scanner;

public class DriversLicenseExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] correctAnswers = {
            'A', 'D', 'B', 'B', 'C', 'B', 'A', 'B', 'C', 'D',
            'A', 'C', 'D', 'B', 'D', 'C', 'C', 'A', 'D', 'B'
        };
        char[] studentAnswers = new char[correctAnswers.length];

        // get an answer for each question
        for (int i = 0; i < studentAnswers.length; i++) {
            studentAnswers[i] = readAnswer(scanner, i + 1);
        }

        // check how many answers match
        int correctCount = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (studentAnswers[i] == correctAnswers[i]) {
                correctCount++;
            }
        }

        System.out.println();
        System.out.println("Correct answers:   " + correctCount);
        System.out.println("Incorrect answers: " + (correctAnswers.length - correctCount));
        System.out.println("Result: " + (correctCount >= 15 ? "PASS" : "FAIL"));
        System.out.println();
        System.out.println("Questions answered incorrectly:");

        boolean first = true;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (studentAnswers[i] != correctAnswers[i]) {
                if (!first) {
                    System.out.print(" ");
                }
                System.out.print(i + 1);
                first = false;
            }
        }
        if (first) {
            System.out.print("None");
        }
        System.out.println();
        scanner.close();
    }

    private static char readAnswer(Scanner scanner, int questionNumber) {
        while (true) {
            System.out.print("Question " + questionNumber + " (A, B, C, or D): ");
            String answer = scanner.nextLine().trim().toUpperCase();
            if (answer.length() == 1 && "ABCD".contains(answer)) {
                return answer.charAt(0);
            }
            System.out.println("Invalid answer. Please enter A, B, C, or D.");
        }
    }
}
