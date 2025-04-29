package ch13.sec02.exam01;

import ch13.sec01.exam01.Product;


public class GenericExample {
    public static void main(String[] args) {
        // K는 Tv 타입, M은 String 타입으로 결정!
        Product<Tv, String> product1 = new Product<>();
        // 위에서 지정한 타입으로 사용해야 한다.
        product1.setKind(new Tv());
        product1.setModel("스마트Tv");

        Tv tv = product1.getKind();
        String tvModel = product1.getModel();

        Product<Car, String> product2 = new Product<>();

        product2.setKind(new Car());
        product2.setModel("SUV자동차");

        Car car = product2.getKind();
        String carModel = product2.getModel();


    }
}
