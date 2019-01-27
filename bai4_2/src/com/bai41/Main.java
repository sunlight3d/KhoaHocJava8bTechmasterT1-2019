package com.bai41;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]) {
        System.out.println("Encapsulation demo");
        Person p1 = new Person("Hoang",
                1979,
                "hoang@gmail.com");
        //p1.name = "Hoang";//Ko thay đổi đc name vì name là private
        //Muốn thay đổi => viết setter của name
        p1.printDetail();
        p1.setName("Hoang B");
        p1.printDetail();
        //Chỉ muốn lấy giá trị name
        //System.out.println(p1.name);//phải lấy qua getter
        System.out.println(p1.getName());
        Person p2 = new Person("Hoang 2",
                1980,
                "hoang2@gmail.com");
        Person p3 = new Person("Hoang 3",
                1981,
                "hoang3@gmail.com");
        List<Person> persons = new ArrayList<Person>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        System.out.println("Duyet danh sach person");
        //Bên trong forEach là 1 "anonymous function"

        persons.forEach(person -> {
            person.printDetail();
        });

        //Kieu enumerate
        for(Person person: persons){
            person.printDetail();
        }
        for(Integer i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            person.printDetail();
        }
        int i = 0;
        for(i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            person.printDetail();
        }
        while (i < persons.size()){
            Person person = persons.get(i);
            person.printDetail();
            i++;
        }
        //filter

        List<Person> filteredPersons = persons.stream().filter(p -> {
            return p.getYearOfBirth() == 1981;
        }).collect(Collectors.toList());

        persons.forEach(person -> {
            person.printDetail();
        });
        System.out.println("Sau khi filter");
        filteredPersons.forEach(person -> {
            person.printDetail();
        });

        //Cach cu- xem de biet
        /*
        List<Person> filteredPersons = new ArrayList<>();
        for(Integer j = 0; j < persons.size(); j++) {
            Person person = persons.get(j);
            if(person.getYearOfBirth() == 1981) {
                filteredPersons.add(person);
            }
        }
        */
    }
}
