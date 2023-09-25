package hexlet.code.games;

import hexlet.code.Engine;

public  class GameEven extends Engine {
    public GameEven(String userName) {
        super(userName);
    }

    public  boolean checkAnswer() {
        if (!getAnswer().equals("yes") && !getAnswer().equals("no")) {
            return false;
        }
        return ((getAnswer().equals("yes") && getRandomGeneratedNumber() % 2 == 0)
                || (getAnswer().equals("no") && getRandomGeneratedNumber() % 2 == 1));
    }
}
