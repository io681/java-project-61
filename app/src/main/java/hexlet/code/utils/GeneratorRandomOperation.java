package hexlet.code.utils;

import java.util.Random;

public class GeneratorRandomOperation {

    public String createRandomOperation() {
        Random random = new Random();
        int numberChoice = random.nextInt(999) % 3;

        switch (numberChoice) {
            case 0:
                return "+";
            case 1:
                return "-";
            case 2:
                return "*";
            default:
                return null;
        }
    }
}
