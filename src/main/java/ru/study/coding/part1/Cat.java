package ru.study.coding.part1;

public abstract class Cat implements Animal, SeasonLovers {

    protected int speed;

    protected Position position;

    public Cat() {
        this.position = new Position();
    }
}
