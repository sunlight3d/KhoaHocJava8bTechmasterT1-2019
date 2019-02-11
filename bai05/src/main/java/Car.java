public class Car {
    private String color;
    private Integer year;
    private String name;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Integer getYear() {
        return year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
    public void run(Integer kilometers) {
        System.out.println("I am running "+kilometers+" kilometers");
    }
}
