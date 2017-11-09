package ru.study.coding.part1;

public class SmallClass {

    private boolean b1;
    private Boolean B1;
    private byte b2;
    private Byte B2;
    private short s1;
    private Short S1;
    private char c1;
    private Character C1;
    public int i;
    public Integer I;
    protected float f1;
    protected Float F1;
    protected double d1;
    protected Double D1;

    public SmallClass() {
        System.out.println("construct SmallClass");
    }

    public float getF1() {
        return f1;
    }

    public void setF1(Float f1) {
        F1 = f1;
    }

    public double getD1() {
        return d1;
    }

    public void setD1(Double d1) {
        D1 = d1;
    }

    public void setD1(double d1) {
        this.d1 = d1;
    }

    public void setF1(float f1) {
        this.f1 = f1;
    }

    public boolean isB1() {
        return b1;
    }

    public void setB1(boolean b1) {
        this.b1 = b1;
    }

    public Boolean getB1() {
        return B1;
    }

    public void setB1(Boolean b1) {
        B1 = b1;
    }

    public byte getB2() {
        return b2;
    }

    public void setB2(Byte b2) {
        B2 = b2;
    }

    public short getS1() {
        return s1;
    }

    public void setS1(Short s1) {
        S1 = s1;
    }

    public char getC1() {
        return c1;
    }

    public void setC1(Character c1) {
        C1 = c1;
    }

    public int getI() {
        return i;
    }

    public void setI(Integer i) {
        I = i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setC1(char c1) {
        this.c1 = c1;
    }

    public void setS1(short s1) {
        this.s1 = s1;
    }

    public void setB2(byte b2) {
        this.b2 = b2;
    }

    @Override
    public String toString() {
        return "SmallClass{" +
                "b1=" + b1 +
                ", B1=" + B1 +
                ", b2=" + b2 +
                ", B2=" + B2 +
                ", s1=" + s1 +
                ", S1=" + S1 +
                ", c1=" + c1 +
                ", C1=" + C1 +
                ", i=" + i +
                ", I=" + I +
                ", f1=" + f1 +
                ", F1=" + F1 +
                ", d1=" + d1 +
                ", D1=" + D1 +
                '}';
    }
}
