package hexlet.code.utils;

import java.util.Random;

public class GeneratorRandomOperation implements GeneratorRandom{
    private final String[] operations = {"+", "-", "*"};
    public final int createNumber(int maxNumber) {
        Random random = new Random();
        return random.nextInt(maxNumber);
    }
    public final String createRandomOperation(int maxNumber) {

        int generatedNumber = createNumber(maxNumber);
        int numberChoice = generatedNumber % operations.length;

        return switch (numberChoice) {
            case 0 -> "+";
            case 1 -> "-";
            case 2 -> "*";
            default -> null;
        };
    }
}
