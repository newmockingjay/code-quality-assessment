package bin.brain_games;

import src.cli.Greeting;
import src.engine.GameEngine;
import src.games.Game;
import src.games.LCMGame;
import src.games.ProgressionGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userName = Greeting.getUserName();

        System.out.println("Choose a game:");
        System.out.println("1. Find the Least Common Multiple (LCM)");
        System.out.println("2. Find the missing number in the geometric progression");
        System.out.print("Enter 1 or 2: ");
        String choice = scanner.nextLine();

        Game selectedGame;

        switch (choice) {
            case "1":
                selectedGame = new LCMGame();
                break;
            case "2":
                selectedGame = new ProgressionGame();
                break;
            default:
                System.out.println("Invalid choice. Exiting the game.");
                return;
        }

        GameEngine.run(selectedGame, userName);
    }
}
