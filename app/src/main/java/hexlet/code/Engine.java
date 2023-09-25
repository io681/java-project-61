package hexlet.code;

import java.util.Scanner;

public class Engine {

    private  String answer;
    private  int randomGeneratedNumber;
    private final Scanner scanner;
    private final String userName;

    public static final  int MAX_COUNT_ROUND = 3;
    public static final  int MAX_NUMBER_RANDOM = 101;

    protected Engine(String userName) {
        this.scanner = new Scanner(System.in);
        this.userName = userName;
    }

    public  void readAnswer() {
        setAnswer(scanner.next());
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUserName() {
        return userName;
    }

    public int getRandomGeneratedNumber() {
        return randomGeneratedNumber;
    }

    public void setRandomGeneratedNumber(int number) {
        this.randomGeneratedNumber = number;
    }
}
