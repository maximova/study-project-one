package ru.study.coding.part1;

public class Tiger extends Cat {

    @Override
    public Season getBestSeason() {
        return Season.SPRING;
    }

    public Tiger() {
        speed = 10;
    }

    public void move() {
        position.setX(position.getX() + speed);
    }

    public void sound() {
        System.out.println("Rrrrrr!");
    }

    @Override
    public String toString() {
        return "Tiger{}" +
                position.toString();
    }
}
