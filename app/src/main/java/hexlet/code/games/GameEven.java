package hexlet.code.games;

import hexlet.code.Engine;

public  class GameEven extends Engine {
    public GameEven() {
        super();
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
    public final void generateTextResultRound(boolean isCorrect) {
        if (isCorrect) {
            System.out.println("Correct!");
        } else {
            switch (getAnswer()) {
                case "yes":
                    System.out.println("'yes' is wrong answer ;(. Correct answer was '" + "no" + "'");
                    break;
                case "no":
                    System.out.println("'no' is wrong answer ;(. Correct answer was '" + "yes" + "'");
                    break;
                default:
                    System.out.println("'" + getAnswer() + "'" + " is wrong answer ;(.");
                    break;
            }
            System.out.println("Let's try again, " + getUserName() + "!");
        }
    }
}
