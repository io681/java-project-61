package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Scanner;


public class GameProgression extends Engine {

    private int valueHiddenNumber;

    public static final int RANGE_START_LENGTH_PROGRESSION = 5;
    public static final int RANGE_END_LENGTH_PROGRESSION = 10;
    public GameProgression(Scanner scannerBrainGameForSet) {
        super(scannerBrainGameForSet);
    }

    public final void generateDescriptionTask() {
        System.out.println("What number is missing in the progression?");
    }

    public  final void createQuestion() {
        String resultProgressionForQuestion = String
                .join(" ",makeProgressionWithHiddenElementForQuestion(generateProgressionRandom()));
        System.out.println("Question: " + resultProgressionForQuestion);
    }

    public  final boolean checkAnswer() {
        return Integer.parseInt(getAnswer()) == getValueHiddenNumber();
    }

    public final int[] generateProgressionRandom() {
        Utils utils = new Utils();

        int startNumberProgression = getGeneratedNumber(0);
        int stepProgression = getGeneratedNumber(1);
        int lengthProgression = utils.createNumberInRange(RANGE_START_LENGTH_PROGRESSION,
                RANGE_END_LENGTH_PROGRESSION);
        int[] progressionNumbers = new int[lengthProgression];

        int nextNumberProgression = startNumberProgression;

        for (var i = 0; i < lengthProgression; i++) {
            progressionNumbers[i] = nextNumberProgression;
            nextNumberProgression += stepProgression;
        }

        return progressionNumbers;
    }

    public final String[] makeProgressionWithHiddenElementForQuestion(int[] progressionArray) {
        Utils utils = new Utils();
        int positionHidden = utils.createNumberInRange(0, progressionArray.length - 1);
        setValueHiddenNumber(progressionArray[positionHidden]);

        String[] progressionArrayStringWithHiddenElement = new String[progressionArray.length];

        for (var i = 0; i < progressionArray.length; i++) {
            if (i == positionHidden) {
                progressionArrayStringWithHiddenElement[i] = "..";
                continue;
            }
            progressionArrayStringWithHiddenElement[i] = Integer.toString(progressionArray[i]);
        }

        return progressionArrayStringWithHiddenElement;
    }

    public final int getValueHiddenNumber() {
        return valueHiddenNumber;
    }

    public final void setValueHiddenNumber(int valueHiddenNumberForSet) {
        this.valueHiddenNumber = valueHiddenNumberForSet;
    }

}
