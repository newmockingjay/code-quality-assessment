package src.engine;

import src.games.Game;
import src.cli.Greeting;

import java.util.Scanner;

public class GameEngine {
    private static final int TOTAL_ROUNDS = 3;

    public static void run(Game game, String userName) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(game.getGameDescription());

        for (int round = 1; round <= TOTAL_ROUNDS; round++) {
            String[] qa = game.generateQuestionAndAnswer();
            String question = qa[0];
            String correctAnswer = qa[1];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!\n");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }
}

