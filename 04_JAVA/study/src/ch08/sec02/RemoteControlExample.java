package ch08.sec02;

public class RemoteControlExample {
    public static void main(String[] args) {
        RemoteControl rc;

        rc = new Television(); //업캐스팅
        rc.turnOn(); // 자식인 Television의 turnOn 호출

        rc = new Audio();
        rc.turnOn();
    }
}
