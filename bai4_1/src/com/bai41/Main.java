package com.bai41;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        System.out.println("Hello");
        Person mrHoang = new Person("Hoang", "hoang@gmail.com", 30);
        Person mrSon = new Person("Son", "son@gmail.com", 31);
        Person mrA = new Person("A", "", 32);
        //Person mrC = new Person();
        mrHoang.printDetail();
        mrSon.printDetail();
        mrA.printDetail();
        mrHoang.login();
        mrHoang.login();
        mrHoang.login();
        mrHoang.printDetail();
        Person.baseSalary = 123;
        //mrHoang.baseSalary = 111;

        mrHoang.printDetail();
        mrSon.printDetail();
        mrA.printDetail();
        System.out.println("ArrayList Example");
        ArrayList<String> skills = new ArrayList<>();
        skills.add("Mathematics");
        skills.add("Musics");
        skills.add("football");
        System.out.println("skills = "+skills);
        mrA.skills = skills;
        mrHoang.printDetail();
        mrSon.printDetail();
        mrA.printDetail();

        System.out.println("Year of birth"+mrA.getYearOfBirth());
    }
}
