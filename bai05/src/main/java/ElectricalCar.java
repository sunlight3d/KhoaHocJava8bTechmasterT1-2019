public class ElectricalCar extends Car{
    @Override
    public void run(Integer kilometers) {
        //super.run(kilometers);
        System.out.println("ElectricalCar is running");
        super.run(kilometers);
        //super.getColor();
    }
}
