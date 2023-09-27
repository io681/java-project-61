package hexlet.code.games;

import hexlet.code.Engine;

public class GamePrime extends Engine {
    public GamePrime() {
        super();
    }

    public void GenerateDescriptionTask() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    public  void createQuestion() {
        System.out.println("Question: " + getGeneratedNumber(0));
    }

    public  boolean checkAnswer() {
        if (!getAnswer().equals("yes") && !getAnswer().equals("no")) {
            return false;
        }

        boolean result = checkContainInArray(generateArrayOfPrime(), Integer.toString(getGeneratedNumber(0)));

        return ((getAnswer().equals("yes") && result) || (getAnswer().equals("no") && !result));
    }
    public  String[] generateArrayOfPrime() {
        String numbersPrime = "";
        int countOperation = 0;

        for (int i = 1; i < MAX_NUMBER_RANDOM; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    countOperation += 1;
                }
            }
            if (countOperation == 1) {
                numbersPrime += i + " ";
            }
            countOperation = 0;
        }

        return numbersPrime.split(" ");
    }

    public boolean checkContainInArray(String[] arrayCheck, String elementCheck) {
        for (String element: arrayCheck) {
            if (element.equals(elementCheck)) {
                return true;
            }
        }
        return false;
    }
}
