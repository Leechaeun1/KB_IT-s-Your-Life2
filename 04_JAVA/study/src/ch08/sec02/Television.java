package ch08.sec02;

public class Television implements RemoteControl{
    // 추상 메소드는 구현 클래스에서 무조건 구현해야 한다.
    @Override
    public void turnOn(){
        System.out.println("TV를 켭니다.");
    }

}
