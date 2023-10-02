package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Arrays;
import java.util.Scanner;


public class GameProgression extends Engine {
    int[] resultHiddenElement = new int[MAX_COUNT_ROUND];
    public static final int RANGE_START_LENGTH_PROGRESSION = 5;
    public static final int RANGE_END_LENGTH_PROGRESSION = 10;
    public GameProgression(Scanner scannerBrainGameForSet) {
        super(scannerBrainGameForSet);
    }

    public final void generateDescriptionTask() {
        System.out.println("What number is missing in the progression?");
    }

    public  final boolean checkAnswer(int numberAnswer) {
        return Integer.parseInt(getAnswer()) == getResultHiddenElement(numberAnswer);
    }

    public final int[] generateProgressionRandom() {
        Utils generatorNumbersUtil = new Utils();

        int startNumberProgression = generatorNumbersUtil.createNumberInRange(MIN_NUMBER_RANDOM,MAX_NUMBER_RANDOM);
        int stepProgression = generatorNumbersUtil.createNumberInRange(MIN_NUMBER_RANDOM,MAX_NUMBER_RANDOM);
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
        String[] DataForQuestionsGameCalc = new String[MAX_COUNT_ROUND];

        for (var i =0; i <  DataForQuestionsGameCalc.length; i++) {
            DataForQuestionsGameCalc[i] = makeProgressionWithHiddenElementForQuestion(i,generateProgressionRandom());
        }

        this.dataForQuestions = Arrays.copyOf(DataForQuestionsGameCalc,DataForQuestionsGameCalc.length);
    }

    public final String makeProgressionWithHiddenElementForQuestion(int currentAnswer ,int[] progressionArray) {
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

    public int getResultHiddenElement(int indexResultCalc) {
        return this.resultHiddenElement[indexResultCalc];
    }

    public void setResultHiddenElement(int indexResultCalc, int valueResultCalc) {
        this.resultHiddenElement[indexResultCalc] = valueResultCalc;
    }
}
