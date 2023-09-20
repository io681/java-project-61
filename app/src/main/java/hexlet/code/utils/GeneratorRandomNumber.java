package hexlet.code.utils;

import java.util.Random;

public class GeneratorRandomNumber {
    private int number;

    public int createNumber() {
        Random random = new Random();
        return random.nextInt(999);
    }
}
