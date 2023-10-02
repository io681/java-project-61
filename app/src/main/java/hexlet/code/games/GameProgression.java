package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Scanner;


public class GameProgression extends Engine {
    private final int[] resultHiddenElements;
    public static final int RANGE_START_LENGTH_PROGRESSION = 5;
    public static final int RANGE_END_LENGTH_PROGRESSION = 10;
    public GameProgression(Scanner scannerBrainGameForSet) {
        super(scannerBrainGameForSet);
        this.resultHiddenElements = new int[MAX_COUNT_ROUND];
    }

    public final void generateDescriptionTask() {
        System.out.println("What number is missing in the progression?");
    }

    public  final boolean checkAnswer(int numberAnswer) {
        return Integer.parseInt(getAnswer()) == getResultHiddenElements()[numberAnswer];
    }

    public final int[] generateProgressionRandom() {
        Utils generatorNumbersUtil = new Utils();

        int startNumberProgression = generatorNumbersUtil.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM);
        int stepProgression = generatorNumbersUtil.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM);
        int lengthProgression = generatorNumbersUtil.createNumberInRange(RANGE_START_LENGTH_PROGRESSION,
                RANGE_END_LENGTH_PROGRESSION);
        int[] progressionNumbers = new int[lengthProgression];

        int nextNumberProgression = startNumberProgression;

        for (var i = 0; i < lengthProgression; i++) {
            progressionNumbers[i] = nextNumberProgression;
            nextNumberProgression += stepProgression;
        }

        return progressionNumbers;
    }

    public final void generateDataForQuestions() {
        for (var i = 0; i < MAX_COUNT_ROUND; i++) {
            String generatedProgressionWithHidden
                    = makeProgressionWithHiddenElementForQuestion(i, generateProgressionRandom());
            setDataForQuestionsByNumber(i, generatedProgressionWithHidden);
        }
    }

    public final String makeProgressionWithHiddenElementForQuestion(int currentAnswer, int[] progressionArray) {
        Utils utils = new Utils();
        int positionHidden = utils.createNumberInRange(0, progressionArray.length - 1);

        setResultHiddenElement(currentAnswer, progressionArray[positionHidden]);

        String[] progressionArrayStringWithHiddenElement = new String[progressionArray.length];

        for (var i = 0; i < progressionArray.length; i++) {
            if (i == positionHidden) {
                progressionArrayStringWithHiddenElement[i] = "..";
                continue;
            }
            progressionArrayStringWithHiddenElement[i] = Integer.toString(progressionArray[i]);
        }

        return String.join(" ", progressionArrayStringWithHiddenElement);
    }

    public final int[] getResultHiddenElements() {
        return this.resultHiddenElements;
    }

    public final void setResultHiddenElement(int indexResultCalc, int valueResultCalc) {
        this.resultHiddenElements[indexResultCalc] = valueResultCalc;
    }
}
