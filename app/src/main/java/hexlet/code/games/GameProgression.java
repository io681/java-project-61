package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;


public class GameProgression extends Engine {

    private String valueHiddenNumber;

    public static final int RANGE_START_LENGTH_PROGRESSION = 5;
    public static final int RANGE_END_LENGTH_PROGRESSION = 10;
    public GameProgression() {
        super();
    }

    public final void generateDescriptionTask() {
        System.out.println("What number is missing in the progression?");
    }

    public  final void createQuestion() {
        System.out.println("Question: " + createProgressionRandom());
    }

    public  final boolean checkAnswer() {
        return getAnswer().equals(getValueHiddenNumber());
    }

    public final String createProgressionRandom() {
        Utils utils = new Utils();

        int startNumberProgression = getGeneratedNumber(0);
        int stepProgression = getGeneratedNumber(1);
        int lengthProgression = utils.createNumberInRange(RANGE_START_LENGTH_PROGRESSION,
                RANGE_END_LENGTH_PROGRESSION);

        String[] progressionNumbers = new String[lengthProgression];
        int positionHidden = utils.createNumberInRange(0, lengthProgression - 1);
        int nextNumber = 0;

        for (var i = 0; i < lengthProgression; i++) {
            progressionNumbers[i] = Integer.toString(startNumberProgression + nextNumber);
            nextNumber += stepProgression;
        }

        setValueHiddenNumber(progressionNumbers[positionHidden]);
        progressionNumbers[positionHidden] = "..";

        return String.join(" ", progressionNumbers);
    }

    public final String getValueHiddenNumber() {
        return valueHiddenNumber;
    }

    public final void setValueHiddenNumber(String valueHiddenNumberForSet) {
        this.valueHiddenNumber = valueHiddenNumberForSet;
    }

}
