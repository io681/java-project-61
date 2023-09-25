package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.GeneratorRandomNumber;

public class GameProgression extends Engine {

    private final int RANGE_START = 5;
    private final int RANGE_END = 10;

    private String valueHiddenNumber;
    public GameProgression(String userName) {
        super(userName);
    }

    public void startGame() {
        var roundCorrect = 0;

        while (roundCorrect < MAX_COUNT_ROUND) {
            createQuestion();
            readAnswer();

            if (checkAnswer(getAnswer())) {
                System.out.println("Correct!");
                roundCorrect += 1;
            } else {
                System.out.println("'" + getAnswer() + "'" + " is wrong answer ;(.");
                System.out.println("Let's try again, " + getUserName() + "!");
                break;
            }
        }

        if (roundCorrect == MAX_COUNT_ROUND) {
            System.out.println("Congratulations, " + getUserName() + "!");
        }
    }

    public  void createQuestion() {
        System.out.println("Question: " + createProgressionRandom());
    }

    public  boolean checkAnswer(String answer) {
        return answer.equals(getValueHiddenNumber());
    }

    public  String createProgressionRandom() {
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
