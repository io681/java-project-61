package hexlet.code;

//import hexlet.code.games.GameEven;
//import hexlet.code.games.GameCalc;
//import hexlet.code.games.GameGCD;
//import hexlet.code.games.GamePrime;
//import hexlet.code.games.GameProgression;


import hexlet.code.services.GameBrainService;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameBrainService gameBrainService = new GameBrainService();

        gameBrainService.generateMenu();
        int numberGameChoice = Integer.parseInt(scanner.next());
        gameBrainService.startGameByChoiceNumber(numberGameChoice);

        scanner.close();
    }

}

