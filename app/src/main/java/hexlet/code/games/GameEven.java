package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Arrays;
import java.util.Scanner;

public  class GameEven extends Engine {
    public GameEven(Scanner scannerBrainGameForSet) {
        super(scannerBrainGameForSet);
    }
    public final void generateDescriptionTask() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    public final void generateDataForQuestions() {
        Utils generatorNumbersUtil = new Utils();
        String[] dataForQuestionsGameEven = new String[MAX_COUNT_ROUND];

        for (var i = 0; i <  dataForQuestionsGameEven.length; i++) {
            dataForQuestionsGameEven[i] = Integer
                   .toString(generatorNumbersUtil.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM));
        }

        this.dataForQuestions = Arrays.copyOf(dataForQuestionsGameEven, dataForQuestionsGameEven.length);
    }

    public final boolean checkAnswer(int numberAnswer) {
        if (!getAnswer().equals("yes") && !getAnswer().equals("no")) {
            return false;
        }

        int numberResultCurrentRound = Integer.parseInt(getDataForQuestionByNumber(numberAnswer));

        return ((getAnswer().equals("yes") && numberResultCurrentRound % 2 == 0)
                || (getAnswer().equals("no") && numberResultCurrentRound % 2 == 1));
    }
}
