package src.games;

import java.util.Scanner;
import java.util.Random;

public class LCMGame implements Game{
    private Random random = new Random();

    @Override
    public String getGameDescription() {
        return "Find the smallest common multiple of given numbers.";
    }

    @Override
    public String[] generateQuestionAndAnswer() {
        int num1 = random.nextInt(100) + 1;
        int num2 = random.nextInt(100) + 1;
        int num3 = random.nextInt(100) + 1;

        String question = num1 + " " + num2 + " " + num3;
        int correctAnswer = lcmOfThree(num1, num2, num3);

        return new String[]{question, String.valueOf(correctAnswer)};
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    private int lcmOfThree(int a, int b, int c) {
        return lcm(lcm(a, b), c);
    }
}
