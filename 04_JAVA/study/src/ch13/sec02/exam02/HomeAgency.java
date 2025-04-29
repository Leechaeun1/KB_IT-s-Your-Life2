package ch13.sec02.exam02;

public class HomeAgency implements Rentable<Home> {
    @Override
    public Home rent() { // 리턴 타입이 P와 동일하게 결정
        return new Home();
    }
}
