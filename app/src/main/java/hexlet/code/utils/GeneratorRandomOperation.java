package hexlet.code.utils;

import java.util.Random;

public class GeneratorRandomOperation {
    private final String[] operations = {"+", "-", "*"};

    public final String createRandomOperation(int maxNumber) {

        Random random = new Random();
        int numberChoice = random.nextInt(maxNumber) % operations.length;

        return switch (numberChoice) {
            case 0 -> "+";
            case 1 -> "-";
            case 2 -> "*";
            default -> null;
        };
    }
}
