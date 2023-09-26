package hexlet.code.games;

import hexlet.code.Engine;

public  class GameEven extends Engine {
    public GameEven(String userName) {
        super(userName);
    }

    public  void createQuestion() {
        System.out.println("Question: " + getGeneratedNumber(0));
    }

    public  boolean checkAnswer() {
        if (!getAnswer().equals("yes") && !getAnswer().equals("no")) {
            return false;
        }
        return ((getAnswer().equals("yes") && getGeneratedNumber(0) % 2 == 0)
                || (getAnswer().equals("no") && getGeneratedNumber(0) % 2 == 1));
    }
}
