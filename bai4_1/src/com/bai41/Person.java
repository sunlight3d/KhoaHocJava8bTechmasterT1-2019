package com.bai41;

import java.util.ArrayList;
import java.util.Calendar;

public class Person {
    //Define properties;
    String name;
    String email;
    Integer age;
    //Integer yearOfBirth;//Ko can
    ArrayList<String> skills;
    Integer loginAttempts;
    static Integer baseSalary;
    //constructor

    Person(){
        //default constructor
        this.name="anonymous";
        this.email= "";
        this.age = 18;
    }

    Person(String name, String email, Integer age){
        //custom constructor
        this.name = name;
        this.email = email;
        this.age = age;
        this.loginAttempts = 0;
    }
    public void login(){
        this.loginAttempts = this.loginAttempts + 1;
    }
    public Integer getYearOfBirth() {
        Integer currentYear = Calendar.getInstance().get(Calendar.YEAR);
        System.out.println("Current year is : "+currentYear);
        return currentYear - this.age;
    }
    /*
    Person(String name,Integer age){
        //custom constructor
        this.name = name;
        this.age = age;
    }
    */
    public void printDetail(){
        if(this.skills == null) {
            System.out.println("Name = "+this.name+
                    ",Email="+this.email+
                    ",loginAttempts="+this.loginAttempts+
                    ",baseSalary="+this.baseSalary+
//                    ",skills 1="+this.skills.get(0)+
                    ",age="+this.age);
        } else {
            System.out.println("Name = "+this.name+
                    ",Email="+this.email+
                    ",loginAttempts="+this.loginAttempts+
                    ",baseSalary="+this.baseSalary+
                    ",skills 1="+this.skills.get(0)+
                    ",age="+this.age);
        }

    }
    public void walk(){
        System.out.println("I am walking");
    }
}
