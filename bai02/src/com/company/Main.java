package com.company;

public class Main {

    public static void main(String[] args) {
        //System.out.println(Calculation.fx1(1200000));
        System.out.println(Calculation.canbac2(25));
        Greeting.sayHello("Jonny");
        Boolean a = true;
        Greeting.getFullName("Nguyen Duc", "Hoang");
        //Calculation.min(155,220);
        //System.out.println(Calculation.min(155,220));
        Integer a1 = 10;
        a1 = 200;
        Integer b1 = 20;
        System.out.println("So nho nhat trong 2 so : "+a1+" va "+b1+" la: "+Calculation.min(a1, b1));
        System.out.println(Calculation.getRate(9));
        Calculation.calculatePerformance();
        System.out.println("So sanh 2 input:");
        System.out.println(Greeting.checkInput("John","john@gmail.com"));
    }
}
