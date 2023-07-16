package service;

import model.Gallows;

import java.util.Scanner;

public class GameService {
    private final Gallows gallows;

    public GameService() {
        this.gallows = new Gallows();
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        int input = gallows.startGame(in);

        if (input == 1) {
            gallows.initNewRound();
            do {
                gallows.nextStep(in);
            } while (!gallows.areYouWin() && !gallows.areYouLose());
            start();
        } else if (input == 2) {
            System.exit(0);
        } else {
            System.out.println("Неверное значение");
            start();
        }
    }
}
