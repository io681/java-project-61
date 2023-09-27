package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.GeneratorRandomGameBrain;

import static hexlet.code.utils.GeneratorRandom.RANGE_END_LENGTH_PROGRESSION;
import static hexlet.code.utils.GeneratorRandom.RANGE_START_LENGTH_PROGRESSION;

public class GameProgression extends Engine {



    private String valueHiddenNumber;
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

    public final void generateTextResultRound(boolean isCorrect) {
        if (isCorrect) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + getAnswer() + "'" + " is wrong answer ;(.");
            System.out.println("Let's try again, " + getUserName() + "!");
        }
    }

    public final String createProgressionRandom() {
        GeneratorRandomGameBrain generatorRandomGameBrain = new GeneratorRandomGameBrain();

        int startNumberProgression = getGeneratedNumber(0);
        int stepProgression = getGeneratedNumber(1);
        int lengthProgression = generatorRandomGameBrain.createNumberInRange(RANGE_START_LENGTH_PROGRESSION,
                RANGE_END_LENGTH_PROGRESSION);

        String[] progressionNumbers = new String[lengthProgression];
        int positionHidden = generatorRandomGameBrain.createNumberInRange(0, lengthProgression - 1);
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
