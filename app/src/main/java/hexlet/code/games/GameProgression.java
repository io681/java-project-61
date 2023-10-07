package hexlet.code.games;

import hexlet.code.Utils;

import static hexlet.code.Engine.MAX_COUNT_ROUND;
import static hexlet.code.Engine.MIN_NUMBER_RANDOM;
import static hexlet.code.Engine.MAX_NUMBER_RANDOM;
import static hexlet.code.Engine.POSITION_QUESTION_ONE;
import static hexlet.code.Engine.POSITION_CORRECT_RESULT_ONE;


public class GameProgression extends Games {
    public static final int RANGE_START_LENGTH_PROGRESSION = 5;
    public static final int RANGE_END_LENGTH_PROGRESSION = 10;

    public final void generateDataForGame() {

        for (var i = 0; i < MAX_COUNT_ROUND; i++) {
            int[] generatedProgression = generateProgressionRandom();
            int resultPositionHidden = generatePositionHiddenForArray(generatedProgression);

            String question = makeProgressionToStringWithHiddenElement(resultPositionHidden, generatedProgression);
            String correctResult = Integer.toString(generatedProgression[resultPositionHidden]);

            setDataForGameByIndex(i, POSITION_QUESTION_ONE, question);
            setDataForGameByIndex(i, POSITION_CORRECT_RESULT_ONE, correctResult);
        }
    }

    public final int[] generateProgressionRandom() {
        int startNumberProgression = Utils.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM);
        int stepProgression = Utils.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM);
        int lengthProgression = Utils.createNumberInRange(RANGE_START_LENGTH_PROGRESSION,
                RANGE_END_LENGTH_PROGRESSION);
        int[] progressionNumbers = new int[lengthProgression];

        int nextNumberProgression = startNumberProgression;

        for (var i = 0; i < lengthProgression; i++) {
            progressionNumbers[i] = nextNumberProgression;
            nextNumberProgression += stepProgression;
        }

        return progressionNumbers;
    }

    public final String makeProgressionToStringWithHiddenElement(int positionHidden, int[] progressionArray) {
        String[] progressionToStringWithHiddenElement = new String[progressionArray.length];

        for (var i = 0; i < progressionArray.length; i++) {
            if (i == positionHidden) {
                progressionToStringWithHiddenElement[i] = "..";
                continue;
            }
            progressionToStringWithHiddenElement[i] = Integer.toString(progressionArray[i]);
        }

        return String.join(" ", progressionToStringWithHiddenElement);
    }

    public final int generatePositionHiddenForArray(int[] progressionArray) {
        return Utils.createNumberInRange(0, progressionArray.length - 1);
    }

    public final String getRuleGame() {
        return "What number is missing in the progression?";
    }
}
