package ru.study.coding.part1;

public class Leopard extends Cat {

    public Leopard() {
        speed = 100;
    }

    public void move() {
        position.setX(position.getX() + speed);
    }

    public void sound() {
        System.out.println("Grrrhh!");
    }

    @Override
    public String toString() {
        return "Leopard{}" +
                position.toString();
    }

    @Override
    public Season getBestSeason() {
        return Season.SUMMER;
    }
}
