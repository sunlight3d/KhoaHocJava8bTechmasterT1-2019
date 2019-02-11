public class Person implements LearnAndStudy, Playable{
    private String name;
    private String email;
    private Integer age;
    //constructor
    public Person(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public void readBook(String bookName) {
        System.out.println("Read book: " + bookName);
    }

    public void playFootball() {
        System.out.println("Play football");
    }

    public void goCamping() {
        System.out.println("Go camping");
    }
}
