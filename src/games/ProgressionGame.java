package src.games;

import java.util.Scanner;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProgressionGame implements Game{
    private Random random = new Random();

    @Override
    public String getGameDescription() {
        return "What number is missing in the progression?";
    }

    @Override
    public String[] generateQuestionAndAnswer() {
        int length = random.nextInt(6) + 5; // Длина прогрессии от 5 до 10
        int start = random.nextInt(10) + 1; // Первое число прогрессии
        int multiplier = random.nextInt(5) + 2; // Множитель для геометрической прогрессии

        int[] progression = new int[length];
        progression[0] = start;

        for (int i = 1; i < length; i++) {
            progression[i] = progression[i - 1] * multiplier;
        }

        // Случайным образом выбираем позицию пропущенного элемента
        int hiddenIndex = random.nextInt(length);
        int correctAnswer = progression[hiddenIndex];

        // Замена числа двумя точками
        progression[hiddenIndex] = -1;

        // Формирование вопроса
        String question = IntStream.range(0, length)
                .mapToObj(i -> progression[i] == -1 ? ".." : String.valueOf(progression[i]))
                .collect(Collectors.joining(" "));

        return new String[]{question, String.valueOf(correctAnswer)};
    }

}

