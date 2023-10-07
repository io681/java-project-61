package hexlet.code;

import java.util.Random;
public class Utils {
    public  static int createNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
