package ru.samcold.classify.domain;

import java.io.Serializable;

public class Proxy implements Serializable {
    private int age;
    private int days;
    private String aIso;

    public Proxy() {
    }

    public Proxy(int age, int days, String aIso) {
        this.age = age;
        this.days = days;
        this.aIso = aIso;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getaIso() {
        return aIso;
    }

    public void setaIso(String aIso) {
        this.aIso = aIso;
    }

    @Override
    public String toString() {
        return "Proxy{" +
                "age=" + age +
                ", days=" + days +
                ", aIso='" + aIso + '\'' +
                '}';
    }
}
