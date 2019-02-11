import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        Person p1 = new Person("Hoang",
                "hoang@gmail.com", 30);
        p1.playFootball();
        p1.goCamping();
        p1.readBook("Tay du ky");
        Person p2 = new Person("Nam",
                "nam@gmail.com", 26);
        Person p3 = new Person("Quan",
                "quan@gmail.com", 31);
        List<Person> persons = new ArrayList<Person>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        Collections.sort(persons);
        for(Person p: persons) {
            System.out.println(p.toString());
        }
    }
}
