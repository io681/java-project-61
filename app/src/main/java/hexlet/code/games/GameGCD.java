package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class GameGCD extends Engine  {

    public GameGCD(Scanner scannerBrainGameForSet) {
        super(scannerBrainGameForSet);
    }

    public final void generateDescriptionTask() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    public  final void createQuestion() {
        System.out.println("Question: " + getGeneratedNumber(0) + " " + getGeneratedNumber(1));
    }

    public final boolean checkAnswer() {
        return (Integer.parseInt(getAnswer()) == resultOperationGDK(getGeneratedNumber(0),
                getGeneratedNumber(1)));
    }

    public final int resultOperationGDK(int numberOne, int numberTwo) {
        var numberGDK = 1;

        for (var i = 1; i <= numberOne; i++) {
            if (numberOne % i == 0 && numberTwo % i == 0) {
                numberGDK = i;
            }
        }

        return numberGDK;

    }
}

