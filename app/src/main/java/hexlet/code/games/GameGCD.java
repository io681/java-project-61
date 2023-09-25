package hexlet.code.games;

import hexlet.code.Engine;

public class GameGCD extends Engine  {

    public GameGCD(String userName) {
        super(userName);
    }

    public  void createQuestion() {
        System.out.println("Question: " + getGeneratedNumber(0) + " " + getGeneratedNumber(1));
    }

    public  boolean checkAnswer() {
        return (getAnswer().equals(resultOperationGDK(getGeneratedNumber(0), getGeneratedNumber(1))));
    }

    public String resultOperationGDK(int numberOne, int numberTwo) {
        var numberGDK = 1;

        for (var i = 1; i < numberOne; i++) {
            if (numberOne % i == 0 && numberTwo % i == 0) {
                numberGDK = i;
            }
        }

        return Integer.toString(numberGDK);

    }
}

