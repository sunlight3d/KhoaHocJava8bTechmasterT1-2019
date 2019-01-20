package com.company;

public class Greeting {
    public static void sayHello(String personName) {
        System.out.println("Hello mr "+personName);
    }
    public static void getFullName(String firstName, String lastName) {
        System.out.println("Fullname = "+firstName+" "+lastName);
    }
    public static Boolean checkInput(String name, String email) {
        String correctName = "John";
        String correctEmail = "john@gmail.com";
        /*
        if (name.equals(correctName) == true && email.equals(correctEmail) == true) {
            return true;
        } else {
            return false;
        }*/

        if (name.equals(correctName) && email.equals(correctEmail)) {
            return true;
        } else {
            return false;
        }
        //return name.equals(correctName) && email.equals(correctEmail);
        /*
        if (name == correctName && email == correctEmail) {
            return true;
        } else {
            return false;
        }*/
        /*
        if (name.equals(correctName) && email.equals(correctEmail)) == true{
            return false;
        } else {
            return true;
        }
        */

        //return !name.equals(correctName) && email.equals(correctEmail);
    }
}
