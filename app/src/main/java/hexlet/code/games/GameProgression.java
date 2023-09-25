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
        int rangeStart = 5;
        int rangeEnd = 10;

        GeneratorRandomNumber generatorRandomNumber = new GeneratorRandomNumber();

        int startNumberProgression = getGeneratedNumber(0);
        int stepProgression = getGeneratedNumber(1);
        int lengthProgression = generatorRandomNumber.createNumberInRange(rangeStart, rangeEnd);

        String[] progressionNumbers = new String[lengthProgression];
        int positionHidden = generatorRandomNumber.createNumberInRange(0, lengthProgression - 1);
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
