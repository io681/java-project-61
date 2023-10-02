package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Scanner;

public class GameGCD extends Engine  {

    private final int[] resultGDK;

    public GameGCD(Scanner scannerBrainGameForSet) {
        super(scannerBrainGameForSet);
        this.resultGDK = new int[MAX_COUNT_ROUND];
    }

    public final void generateDescriptionTask() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    public final boolean checkAnswer(int numberAnswer) {
        return (Integer.parseInt(getAnswer()) == getResultGDK()[numberAnswer]);
    }

    public final void generateDataForQuestions() {
        Utils generatorNumbersUtil = new Utils();

        for (var i = 0; i < MAX_COUNT_ROUND; i++) {
            int numberOne = generatorNumbersUtil.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM);
            int numberTwo = generatorNumbersUtil.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM);

            setResultGDK(i, resultOperationGDK(numberOne, numberTwo));
            setDataForQuestionsByNumber(i, numberOne + " " + numberTwo);
        }
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

    public final int[] getResultGDK() {
        return this.resultGDK;
    }

    public final void setResultGDK(int indexResultCalc, int valueResultCalc) {
        this.resultGDK[indexResultCalc] = valueResultCalc;
    }
}

