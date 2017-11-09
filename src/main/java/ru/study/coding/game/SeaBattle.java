package ru.study.coding.game;

public class SeaBattle {

    public static void main(String[] args) {
        String rules = "1 - OOOO\n2 - OOO\n3 - OO\n4 - O\n";

        System.out.println(rules);


        char[][] fieldPlayer1 = SeaBattleMapGenerator.getField();
        System.out.println("field player1: ");

        for (int i = 0; i < 10; i = i + 1) {
            for (int g = 0; g < 10 ; g = g + 1 ) {
                System.out.print(fieldPlayer1[i][g]);
            }
            System.out.println();
        }

        System.out.println(SeaBattleMapGenerator.generateBeautifulField(fieldPlayer1));

        char[][] fieldPlayer2 = SeaBattleMapGenerator.getField();
        System.out.println("field player2: ");
        System.out.println(SeaBattleMapGenerator.generateBeautifulField(fieldPlayer2));
    }
}
