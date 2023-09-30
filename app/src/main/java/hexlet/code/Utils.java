package hexlet.code;

import java.util.Random;
public class Utils {

    public static final int RANGE_START_LENGTH_PROGRESSION = 5;
    public static final int RANGE_END_LENGTH_PROGRESSION = 10;

    public  final int createNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
