package ru.study.coding.game;

public class TicTacToe {

    private char[][] field;
    private static final char BAD_RESPONSE = '-';
    private static final char X_SYMBOL = 'X';
    private static final char O_SYMBOL = 'O';
    private static final char EMPTY_SYMBOL = ' ';
    private char player;

    public TicTacToe() {
        player = X_SYMBOL;
        field = new char[3][3];
        field[0][0] = EMPTY_SYMBOL;
        field[0][1] = EMPTY_SYMBOL;
        field[0][2] = EMPTY_SYMBOL;
        field[1][0] = EMPTY_SYMBOL;
        field[1][1] = EMPTY_SYMBOL;
        field[1][2] = EMPTY_SYMBOL;
        field[2][0] = EMPTY_SYMBOL;
        field[2][1] = EMPTY_SYMBOL;
        field[2][2] = EMPTY_SYMBOL;
    }

    public TicTacToe(int smartInitialize) {
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                field[i][j] = EMPTY_SYMBOL;
            }
        }
    }

    public char getPlayer() {
        return player;
    }

    public void changePlayer() {
        if (player == X_SYMBOL) {
            player = O_SYMBOL;
        } else {
            player = X_SYMBOL;
        }
    }

    public boolean turn(int x, int y) {
        if (field[x - 1][y - 1] != EMPTY_SYMBOL) {
            System.out.println("x = " + x + ", y = " + y + ", symbol = " + field[x-1][y-1]);
            return false;
        }
        field[x - 1][y - 1] = player;
        changePlayer();
        return true;
    }

    public static char getBadResponse() {
        return BAD_RESPONSE;
    }

    public static char getxSymbol() {
        return X_SYMBOL;
    }

    public static char getoSymbol() {
        return O_SYMBOL;
    }

    public char getFieldSymbol(int x, int y) {
        return field[x-1][y-1];
    }

    public char checkWin() {
        char horizontalCheck1 = checkHorizontal(1);
        char horizontalCheck2 = checkHorizontal(2);
        char horizontalCheck3 = checkHorizontal(3);
        char verticalCheck1 = checkVertical(1);
        char verticalCheck2 = checkVertical(2);
        char verticalCheck3 = checkVertical(3);
        char diagonalsCheck = chekDiagonals();
        if (horizontalCheck1 != BAD_RESPONSE) {
            return horizontalCheck1;
        }
        if (horizontalCheck2 != BAD_RESPONSE) {
            return horizontalCheck2;
        }
        if (horizontalCheck3 != BAD_RESPONSE) {
            return horizontalCheck3;
        }
        if (verticalCheck1 != BAD_RESPONSE) {
            return verticalCheck1;
        }
        if (verticalCheck2 != BAD_RESPONSE) {
            return verticalCheck2;
        }
        if (verticalCheck3 != BAD_RESPONSE) {
            return verticalCheck3;
        }
        if (diagonalsCheck != BAD_RESPONSE) {
            return diagonalsCheck;
        }
        return BAD_RESPONSE;
    }

    private char checkHorizontal(int lineNum) {
        if ((field[lineNum - 1][0] == field[lineNum - 1][1]) &&
                (field[lineNum - 1][1] == field[lineNum - 1][2]) &&
                (field[lineNum - 1][0] != EMPTY_SYMBOL)) {
            return field[lineNum - 1][0];
        } else {
            return BAD_RESPONSE;
        }
    }

    private char checkVertical(int lineNum) {
        if ((field[0][lineNum - 1] == field[1][lineNum - 1]) &&
                (field[1][lineNum - 1] == field[2][lineNum - 1]) &&
                (field[0][lineNum - 1] != EMPTY_SYMBOL)) {
            return field[lineNum - 1][0];
        } else {
            return BAD_RESPONSE;
        }
    }

    private char chekDiagonals() {
        if ((field[0][0] == field[1][1]) && (field[1][1] == field[2][2]) && (field[0][0] != EMPTY_SYMBOL)) {
            return field[0][0];
        }
        if ((field[0][2] == field[1][1]) &&(field[1][1] == field[2][0]) && (field[0][2] != EMPTY_SYMBOL)) {
            return field[0][2];
        }
        return BAD_RESPONSE;
    }

    @Override
    public String toString() {
        String fieldString = "";
        fieldString = fieldString + field[0][0] + '|' + field[0][1] + '|' + field[0][2] + "\n";
        fieldString = fieldString + "-+-+-\n";
        fieldString = fieldString + field[1][0] + '|' + field[1][1] + '|' + field[1][2] + "\n";
        fieldString = fieldString + "-+-+-\n";
        fieldString = fieldString + field[2][0] + '|' + field[2][1] + '|' + field[2][2] + "\n";
        return fieldString;
    }
}
