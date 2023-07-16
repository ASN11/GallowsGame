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
        int res = gallows.startGame(in);

        if (res == 1) {
            gallows.initNewRound();
            while (true) {
                gallows.nextStep(in);
                if (gallows.areYouWin() || gallows.areYouLose()) {
                    break;
                }
            }
            start();
        } else if (res == 2) {
            System.exit(0);
        } else {
            System.out.println("Неверное значение");
            start();
        }
    }
}
