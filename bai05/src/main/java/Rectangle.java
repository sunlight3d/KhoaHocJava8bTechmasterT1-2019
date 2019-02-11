public class Rectangle extends Shape {
    private Double width;
    private Double height;
    @Override
    public Double getArea() {
        return width*height;
    }

    @Override
    public Double getLength() {
        return 2*width*height;
    }

    @Override
    public Double getPerimeter() {
        System.out.println("Caculating perimeter");
        return null;
    }
}
