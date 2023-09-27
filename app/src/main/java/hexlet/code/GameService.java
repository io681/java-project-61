package hexlet.code;

public interface GameService {
    public static final int NUMBER_EVEN = 2;
    public static final int NUMBER_CALC = 3;
    public static final int NUMBER_GCD = 4;

    public static final int NUMBER_PROGRESSION = 5;

    public static final int NUMBER_PRIME = 6;

    void startGameByChoiceNumber(int numberGame);
    void generateMenu();

}
