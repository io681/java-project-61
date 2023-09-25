package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.GeneratorRandomNumber;

public class GameProgression extends Engine {



    private String valueHiddenNumber;
    public GameProgression(String userName) {
        super(userName);
    }

    public  void createQuestion() {
        System.out.println("Question: " + createProgressionRandom());
    }

    public  boolean checkAnswer() {
        return getAnswer().equals(getValueHiddenNumber());
    }

    public  String createProgressionRandom() {
        int RANGE_START = 5;
        int RANGE_END = 10;

        GeneratorRandomNumber generatorRandomNumber = new GeneratorRandomNumber();

        int startNumberProgression = generatorRandomNumber.createNumber(MAX_NUMBER_RANDOM);
        int stepProgression = generatorRandomNumber.createNumber(MAX_NUMBER_RANDOM);
        int lengthProgression = generatorRandomNumber.createNumberInRange(RANGE_START,RANGE_END);

        String[] progressionNumbers = new String[lengthProgression];
        int positionHidden = generatorRandomNumber.createNumberInRange(0,lengthProgression);
        int nextNumber = 0;

        for (var i = 0; i < lengthProgression; i++) {
            progressionNumbers[i] = Integer.toString(startNumberProgression + nextNumber);
            nextNumber += stepProgression;
        }

        setValueHiddenNumber(progressionNumbers[positionHidden]);
        progressionNumbers[positionHidden] = "..";

        return String.join(" ", progressionNumbers);
    }

    public String getValueHiddenNumber() {
        return valueHiddenNumber;
    }

    public void setValueHiddenNumber(String valueHiddenNumber) {
        this.valueHiddenNumber = valueHiddenNumber;
    }

}
