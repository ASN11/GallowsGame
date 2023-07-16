package model;

import java.util.Scanner;

public class Gallows {

    private String word;
    private String secretWord;
    private StringBuilder wrongAttempts;
    private int errCount;
    private final Position[] positions;
    private final RandomWordFromFile randomWordFromFile;

    public Gallows() {
        randomWordFromFile = new RandomWordFromFile();
        word = randomWordFromFile.getWord().toLowerCase();
        secretWord = "_".repeat(word.length());
        positions = Position.values();
    }

    public int startGame(Scanner in) {
        System.out.println("\u001B[31m___Игра 'Виселица'___\n\u001B[0m");
        System.out.println("\u001B[32m1\u001B[0m - Начать игру");
        System.out.println("\u001B[32m2\u001B[0m - Выйти из игры");

        return in.nextInt();
    }

    public void nextStep(Scanner in) {
        System.out.println(positions[errCount].getPositionName());
        System.out.println("Слово: \u001B[32m" + secretWord + "\u001B[0m");
        System.out.println("Ошибки (\u001B[31m" + errCount + "\u001B[0m) " + wrongAttempts);
        System.out.print("Буква: ");

        changeGuessWord(in.next().charAt(0));
    }

    public void changeGuessWord(char letter) {
        char[] charGuessWord = secretWord.toCharArray();
        char[] charWord = word.toCharArray();
        boolean flag = false;
        for (int i = 0; i < charGuessWord.length; i++) {
            if (charWord[i] == letter) {
                charGuessWord[i] = letter;
                flag = true;
            }
        }
        if (!flag) {
            if (wrongAttempts.indexOf(String.valueOf(letter)) < 0) {
                wrongAttempts.append(letter).append(" ");
                errCount++;
            }
        } else {
            secretWord = new String(charGuessWord);
        }
    }

    public boolean areYouWin() {
        if (!secretWord.contains("_")) {
            System.out.println("Слово - " + word);
            System.out.println("\n\u001B[32mПОБЕДА!!!\u001B[0m\n");
            return true;
        }
        return false;
    }

    public boolean areYouLose() {
        if (errCount == 6) {
            System.out.println(positions[errCount].getPositionName());
            System.out.println("Слово: \u001B[32m" + secretWord + "\u001B[0m");
            System.out.println("Ошибки (\u001B[31m" + errCount + "\u001B[0m)");
            System.out.println("Слово - " + word);
            System.out.println("\n\u001B[31mТЫ ПРОИГРАЛ!!!\u001B[0m\n");
            return true;
        }
        return false;
    }

    public void initNewRound() {
        word = randomWordFromFile.getWord().toLowerCase();
        secretWord = "_".repeat(word.length());
        wrongAttempts = new StringBuilder();
        errCount = 0;
    }
}
