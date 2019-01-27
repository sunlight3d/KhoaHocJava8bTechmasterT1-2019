package com.bai41;

import java.util.ArrayList;
import java.util.Calendar;

public class Person {
    private String name;
    private Integer yearOfBirth;
    private String email;
    //custom constructor
    public Person(String name,Integer yearOfBirth,String email) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.email = email;
    }
    //viết setter của name
    public void setName(String newName) {
        this.name = newName;
    }
    public String getName() {
        return this.name;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void printDetail(){
        System.out.println("Name = "+this.name+
                ",YearOfBirth = "+this.yearOfBirth+
                ",email = "+this.email);
    }
}
