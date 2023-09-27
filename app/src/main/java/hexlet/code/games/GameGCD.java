package hexlet.code.games;

import hexlet.code.Engine;

public class GameGCD extends Engine  {

    public GameGCD() {
        super();
    }

    public final void generateDescriptionTask() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    public  final void createQuestion() {
        System.out.println("Question: " + getGeneratedNumber(0) + " " + getGeneratedNumber(1));
    }

    public final boolean checkAnswer() {
        return (getAnswer().equals(resultOperationGDK(getGeneratedNumber(0), getGeneratedNumber(1))));
    }

    public final void generateTextResultRound(boolean isCorrect) {
        if (isCorrect) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + getAnswer() + "'" + " is wrong answer ;(.");
            System.out.println("Let's try again, " + getUserName() + "!");
        }
    }
    public final String resultOperationGDK(int numberOne, int numberTwo) {
        var numberGDK = 1;

        for (var i = 1; i <= numberOne; i++) {
            if (numberOne % i == 0 && numberTwo % i == 0) {
                numberGDK = i;
            }
        }

        return Integer.toString(numberGDK);

    }
}

