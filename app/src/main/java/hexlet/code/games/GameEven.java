package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public  class GameEven extends Engine {
    public GameEven(Scanner scannerBrainGameForSet) {
        super(scannerBrainGameForSet);
    }
    public final void generateDescriptionTask() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }
    public final void createQuestion() {
        System.out.println("Question: " + getGeneratedNumber(0));
    }

    public final boolean checkAnswer() {
        if (!getAnswer().equals("yes") && !getAnswer().equals("no")) {
            return false;
        }
        return ((getAnswer().equals("yes") && getGeneratedNumber(0) % 2 == 0)
                || (getAnswer().equals("no") && getGeneratedNumber(0) % 2 == 1));
    }
}
