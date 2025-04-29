package ch13.sec02.exam02;

public class GenericExample {
    public static void main(String[] args) {
        HomeAgency homeAgency = new HomeAgency();
        Home home = homeAgency.rent();
        home.turnOnLight();

        CarAgency carAgency = new CarAgency();
        // 제네릭 인터페이스를 통해 리턴 타입을 고정
        Car car = carAgency.rent();
        car.run();
    }
}
