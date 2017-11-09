package ru.study.coding.game;

import java.util.Scanner;

public class GameManager {

    private TicTacToe ticTacToe;
    private int x;
    private int y;

    public GameManager() {
        ticTacToe = new TicTacToe();
    }

    public void gameCycle() {
        while (ticTacToe.checkWin() == TicTacToe.getBadResponse()) {
            askInput(ticTacToe);
            while (checkXY(x, y) && !ticTacToe.turn(x, y)) {
                System.out.println("Клетка уже занята или введены не верно координаты. Ввод: " + x + ", " + y +
                        ". Символ в этой клетке: " + ticTacToe.getFieldSymbol(x, y));
                askInput(ticTacToe);
            }
        }
        ticTacToe.changePlayer();
        System.out.println(ticTacToe);
        System.out.println("Победитель: игрок " + ticTacToe.getPlayer());
    }

    private void askInput(TicTacToe ticTacToe) {
        System.out.println(ticTacToe);
        System.out.println("Ход игрока " + ticTacToe.getPlayer());
        String INFO = "Введите номер строки и номер столбца для хода через запятую. Номера должны быть от 1 до 3. Пример: 3,2";
        System.out.println(INFO);
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String[] inputString = s.split(",");
        x = Integer.parseInt(inputString[0]);
        y = Integer.parseInt(inputString[1]);
    }

    private boolean checkXY(int x, int y) {
        return (1 <= x) && (x <= 3) && (1 <= y) && (y <= 3);
    }
}
