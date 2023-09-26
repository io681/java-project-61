package hexlet.code.utils;

import java.util.Random;

public class GeneratorRandomNumber {

    public int createNumber(int maxNumber) {
        Random random = new Random();
        return random.nextInt(maxNumber);
    }
    public int createNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
