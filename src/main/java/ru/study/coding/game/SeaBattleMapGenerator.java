package ru.study.coding.game;

import java.util.Random;

public class SeaBattleMapGenerator {

    public final static char USED_EMPTY = '+';
    public final static char LIVE_SHIP_PART = 'O';
    public final static char DEAD_SHIP_PART = 'X';
    public final static char UNUSED_EMPTY = '-';

    public static char[][] getField() {
        char[][] field = getFilledField();
        generateNavy(field);
        replaceUnusedToUsedSymbols(field);
        return field;
    }

    public static String generateBeautifulField(char[][] field) {
        String beautifulField =  "   а б в г д е ж з и к\n";
        for (int i = 1; i <= 10; i++) {
            if (i != 10) {
                beautifulField += " " + i;
            } else {
                beautifulField += i;
            }
            for (int j = 1; j <= 10; j++) {
                beautifulField += " " + field[i - 1][j - 1];
            }
            beautifulField += "\n";
        }
        return beautifulField;
    }

    private static char[][] getFilledField() {
        char[][] field = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                field[i][j] = USED_EMPTY;
            }
        }
        return field;
    }

    private static void generateNavy(char[][] field) {
        for (int i = 4; i > 0; i--) {
            for (int j = 1; j <= 5 - i; j++) {
                generateShip(i, field);
            }
        }
    }

    private static void generateShip(int shipSize, char[][] field) {
        int[] usefullX = new int[100];
        int[] usefullY = new int[100];
        int usefullCount = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (field[i][j] == USED_EMPTY) {
                    usefullCount++;
                    usefullX[usefullCount - 1] = i;
                    usefullY[usefullCount - 1] = j;
                }
            }
        }
        Random random = new Random();
        int x, y, randomCellNumber;
        do {
            randomCellNumber = random.nextInt(usefullCount);
            x = usefullX[randomCellNumber];
            y = usefullY[randomCellNumber];
        } while (!checkDirections(shipSize, field, x, y));
    }

    private static boolean checkDirections(int shipSize, char[][] field, int x, int y) {
        Random random = new Random();
        int direction = random.nextInt(2);
        if (direction == 0) {
            if (!checkHorizontalVariants(shipSize, field, x, y)) {
                return checkVerticalVariants(shipSize, field, x, y);
            } else {
                return true;
            }
        } else {
            if (!checkVerticalVariants(shipSize, field, x, y)) {
                return checkHorizontalVariants(shipSize, field, x, y);
            } else {
                return true;
            }
        }
    }

    private static boolean checkHorizontalVariants(int shipSize, char[][] field, int x, int y) {
        for (int startY = 1 + y - shipSize; startY <= y; startY++) {
            try {
                if (checkHorizontalShip(shipSize, field, x, startY)) {
                    insertShipToField(shipSize, field, x, startY, 'x');
                    return true;
                }
            } catch (Exception e) {}
        }
        return false;
    }

    private static boolean checkVerticalVariants(int shipSize, char[][] field, int x, int y) {
        for (int startX = 1 + x - shipSize; startX <= x; startX++) {
            try {
                if (checkVerticalShip(shipSize, field, startX, y)) {
                    insertShipToField(shipSize, field, startX, y, 'y');
                    return true;
                }
            } catch (Exception e) {}
        }
        return false;
    }

    //return true if all cells contain USED_EMPTY symbol '+' in horizontal direction
    private static boolean checkHorizontalShip(int shipSize, char[][] field, int startX, int startY) {
        for (int deltaY = 0; deltaY < shipSize; deltaY++) {
            if (field[startX][startY + deltaY] != USED_EMPTY) {
                return false;
            }
        }
        return true;
    }

    //return true if all cells contain USED_EMPTY symbol '+' in vertical direction
    private static boolean checkVerticalShip(int shipSize, char[][] field, int startX, int startY) {
        for (int deltaX = 0; deltaX < shipSize; deltaX++) {
            if (field[startX + deltaX][startY] != USED_EMPTY) {
                return false;
            }
        }

        return true;
    }

    //create ship start in (startX,startY) with shipSize length. Direction - x for horizontal, y for vertical.
    private static void insertShipToField(int shipSize, char[][] field, int startX, int startY, char direction) {
        if (direction == 'x') {
            for (int deltaY = 0; deltaY < shipSize; deltaY++) {
                field[startX][startY + deltaY] = LIVE_SHIP_PART;
            }
        } else if (direction == 'y') {
            for (int deltaX = 0; deltaX < shipSize; deltaX++) {
                field[startX + deltaX][startY] = LIVE_SHIP_PART;
            }
        }
        updateUnusedEmpty(field);
    }

    //fill filed by UNUSED_EMPTY symbols around all ships
    private static void updateUnusedEmpty(char[][] field) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (field[i][j] == LIVE_SHIP_PART) {
                    updateSquare(field, i, j);
                }
            }
        }
    }

    //fill area around ship cell by UNUSED_EMPTY symbol = '-'
    private static void updateSquare(char[][] field, int x, int y) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                try {
                    if (field[x + i][y + j] == USED_EMPTY) {
                        field[x + i][y + j] = UNUSED_EMPTY;
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    private static void replaceUnusedToUsedSymbols(char[][] field) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (field[i][j] == UNUSED_EMPTY) {
                    field[i][j] = USED_EMPTY;
                }
            }
        }
    }

    private static void printField(char[][] field) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
