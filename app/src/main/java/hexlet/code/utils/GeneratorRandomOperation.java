package hexlet.code.utils;

import java.util.Random;

public class GeneratorRandomOperation {

    public String createRandomOperation() {
        int MAX_BOUND = 999;
        int COUNT_OPERATIONS = 3;

        Random random = new Random();
        int numberChoice = random.nextInt(MAX_BOUND) % COUNT_OPERATIONS;

        return switch (numberChoice) {
            case 0 -> "+";
            case 1 -> "-";
            case 2 -> "*";
            default -> null;
        };
    }
}
