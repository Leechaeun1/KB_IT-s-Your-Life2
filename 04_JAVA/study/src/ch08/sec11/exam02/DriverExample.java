package ch08.sec11.exam02;

public class DriverExample {
    public static void main(String[] args) {
        Driver driver = new Driver();

        Bus bus = new Bus();
        Taxi taxi = new Taxi();

        // 매개변수의 다형성
        driver.drive(bus);
        driver.drive(taxi);
    }
}
