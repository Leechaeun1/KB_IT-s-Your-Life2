package ch08.sec09;

// 인터페이스가 인터페이스를 상속받을 때는 extends 사용
public interface InterfaceC extends InterfaceA, InterfaceB {
    void methodC();
}
