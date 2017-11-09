package ru.study.coding.part1;

public class AnimalManger {

    public Cat[] cats = {new Tiger(), new Leopard(), new Tiger()};

    public static void main(String[] args) {
        AnimalManger animalManger = new AnimalManger();
        for (int i = 0; i < 4; i++) {
            for (Animal animal : animalManger.cats) {
                System.out.println(animal);
                animal.move();
                animal.sound();
            }
        }
        for (SeasonLovers seasonLover : animalManger.cats) {
            System.out.println(seasonLover.toString() + ", best season is: " + seasonLover.getBestSeason());
        }
    }
}
