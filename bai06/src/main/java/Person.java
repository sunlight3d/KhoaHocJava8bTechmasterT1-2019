public class Person implements LearnAndStudy, Playable, Comparable{
    private String name;
    private String email;
    private Integer age;

    @Override
    public String toString() {
        return "Name: "+name+".Email:"+email+".Age:"+age;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

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
    /*
    public int compareTo(Object o) {
        Person a = (Person) o;
        Person b = this;
        if(a.getAge() > b.getAge()) {
            return -1;
        } else if (a.getAge() < b.getAge()){
            return 1;
        }
        return 0;
    }
    */
    public int compareTo(Object o) {
        Person a = (Person) o;
        Person b = this;
        return -a.getName().compareTo(b.getName());
    }
}
