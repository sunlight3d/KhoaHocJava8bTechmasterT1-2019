public class Main {
    public static void main(String[] args) {
        System.out.println("Helllp");
        Car car1 = new Car();
        car1.run(120);
        ElectricalCar electricalCar1 = new ElectricalCar();
        electricalCar1.run(235);
        Shape s1 = new Shape() {
            @Override
            public Double getArea() {
                return 10.0;
            }

            @Override
            public Double getPerimeter() {
                return null;
            }

            @Override
            public Double getLength() {
                return null;
            }
        };
        Shape r1 = new Rectangle();
        r1.getPerimeter();

    }
}
