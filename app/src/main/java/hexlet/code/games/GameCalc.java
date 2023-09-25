package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.GeneratorRandomNumber;
import hexlet.code.utils.GeneratorRandomOperation;

public class GameCalc extends Engine {

    private  int randomGeneratedNumberSecond;
    private  String randomOperation;

    public GameCalc(String userName) {
        super(userName);
    }

    public  void createQuestion() {
        GeneratorRandomNumber generatorRandomNumber = new GeneratorRandomNumber();
        GeneratorRandomOperation generatorRandomOperation = new GeneratorRandomOperation();

        setRandomGeneratedNumber(generatorRandomNumber.createNumber(MAX_NUMBER_RANDOM));
        setRandomGeneratedNumberSecond(generatorRandomNumber.createNumber(MAX_NUMBER_RANDOM));
        setRandomOperation(generatorRandomOperation.createRandomOperation());

        System.out.println("Question: " + getRandomGeneratedNumber() + " " + getRandomOperation()
                + " " + getRandomGeneratedNumberSecond());
    }

    public  boolean checkAnswer() {
        return (getAnswer().equals(resultOperation(getRandomOperation(),getRandomGeneratedNumber()
                ,getRandomGeneratedNumberSecond())));
    }

    public String resultOperation(String operation, int numberOne, int numberTwo) {
        return switch (operation) {
            case "+" -> Integer.toString(numberOne + numberTwo);
            case "-" -> Integer.toString(numberOne - numberTwo);
            case "*" -> Integer.toString(numberOne * numberTwo);
            default -> "not correct data";
        };
    }
    public String getRandomOperation() {
        return randomOperation;
    }

    public void setRandomOperation(String randomOperation) {
        this.randomOperation = randomOperation;
    }

    public int getRandomGeneratedNumberSecond() {
        return randomGeneratedNumberSecond;
    }

    public void setRandomGeneratedNumberSecond(int randomGeneratedNumberSecond) {
        this.randomGeneratedNumberSecond = randomGeneratedNumberSecond;
    }

}
