package ru.study.coding.game;

import java.util.Scanner;

public class ProcedureTicTacToe {

    private static final Scanner scanner = new Scanner(System.in);

    private char playerSymbol = 'X';
    private char[][] cells = new char[3][3];
    private String field;
    private int turnCounter;

    public void play() {
        System.out.println("Hello in tic-tac-toe game");
        for (int i = 0; i <= 2; i = i + 1) {
            for (int g = 0; g <= 2; g = g + 1) {
                cells[i][g] = ' ';
            }
        }
        formField();
        System.out.println(field);
        gameCycle();
    }

    private void gameCycle() {
        turnCounter = 0;
        boolean gameEndCondition = false;
        while (!gameEndCondition) {
            userInput();
            formField();
            System.out.println(field);
            gameEndCondition = checkWin(turnCounter);
            changePlayer();
        }
    }

    private void changePlayer() {
        if (playerSymbol == 'X') {
            playerSymbol = '0';
        } else if (playerSymbol == '0') {
            playerSymbol = 'X';
        }
    }

    private boolean checkWin(int turnCounter) {
        turnCounter = turnCounter + 1;
        System.out.println("turnCOunter" + turnCounter);
        if ((cells[0][0] == cells[0][1]) && (cells[0][1] == cells[0][2]) && (cells[0][0] != ' ')) {
            System.out.println("Победил " + playerSymbol); //win first horizontal
            return true;
        } else if ((cells[1][0] == cells[1][1]) && (cells[1][1] == cells[1][2]) && (cells[1][0] != ' ')) {
            System.out.println("Победил " + playerSymbol); //win first horizontal
            return true;
        } else if ((cells[2][0] == cells[2][1]) && (cells[2][1] == cells[2][2]) && (cells[2][0] != ' ')) {
            System.out.println("Победил " + playerSymbol); //win first horizontal
            return true;
        } else if ((cells[0][0] == cells[1][0]) && (cells[1][0] == cells[2][0]) && (cells[0][0] != ' ')) {
            System.out.println("Победил " + playerSymbol); //win first horizontal
            return true;
        } else if ((cells[0][1] == cells[1][1]) && (cells[1][1] == cells[2][1]) && (cells[0][1] != ' ')) {
            System.out.println("Победил " + playerSymbol); //win first horizontal
            return true;
        } else if ((cells[0][2] == cells[1][1]) && (cells[1][2] == cells[2][2]) && (cells[0][2] != ' ')) {
            System.out.println("Победил " + playerSymbol); //win first horizontal
            return true;
        } else if ((cells[0][0] == cells[1][1]) && (cells[1][1] == cells[2][2]) && (cells[0][0] != ' ')) {
            System.out.println("Победил " + playerSymbol); //win first horizontal
            return true;
        } else if ((cells[0][2] == cells[1][1]) && (cells[1][1] == cells[2][0]) && (cells[0][2] != ' ')) {
            System.out.println("Победил " + playerSymbol); //win first horizontal
            return true;
        } else if (turnCounter == 9) {
            System.out.println("Ничья");
            return true;
        } else {
            return false;
        }
    }

    private void formField() {
        field = cells[0][0] + "|" + cells[0][1] + "|" + cells[0][2] + "\n" +
                "-+-+-\n" +
                cells[1][0] + "|" + cells[1][1] + "|" + cells[1][2] + "\n" +
                "-+-+-\n" +
                cells[2][0] + "|" + cells[2][1] + "|" + cells[2][2] + "\n";
    }

    private void userInput() {
        System.out.println("Введите х");
        int x = scanner.nextInt();
        System.out.println("Введите y");
        int y = scanner.nextInt();
        cells[x - 1][y - 1] = playerSymbol;
    }
}
