package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.MAX_COUNT_ROUND;
import static hexlet.code.Engine.STRUCTURE_ROUND;

public abstract class Games {
    private final String[][] dataForGame;
    public Games() {
        this.dataForGame = new String[MAX_COUNT_ROUND][STRUCTURE_ROUND.length];
    }

    public final String[][] getDataForGame() {
        return dataForGame;
    }

    public final void setDataForGameByIndex(int indexOne, int indexTwo, String value) {
        this.dataForGame[indexOne][indexTwo] = value;
    }

    public abstract String[][]  generateDataForGame();
    public abstract String getRuleGame();

    public final void startGame() {
        Engine.runGame(generateDataForGame(), getRuleGame());
    }
}
