package com.company;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        System.out.println("Hello world 1");
        System.out.println("Hello world 2");
        //String concatenation, or "String template"
        String s1 = "Hello \n";
        String s2 = " Mr Hoang";
        String s3 = s1 + s2;
        System.out.println(s3);
        String s4 = "mr Hoang said \"How are you?\" ";
        System.out.println(s4);
        //sum 2 numbers
        Integer x = 10;
        Integer y = 20;
        System.out.print("Sum = ");
        System.out.println(x+y);

        //System.out.print("Sum = "+Integer.toString(x+y));
        System.out.println("Sum = "+sum2Numbers(100,200));
    }
    private static Integer sum2Numbers(Integer x, Integer y) {
        return  x + y;
    }
}
