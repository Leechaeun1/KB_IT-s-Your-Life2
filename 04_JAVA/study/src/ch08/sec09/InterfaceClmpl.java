package ch08.sec09;

public class InterfaceClmpl implements InterfaceC {
    // 부모 인터페이스의 상위 인처페이스까지 구현해야 함

    @Override
    public void methodC() {
        System.out.println("InterfaceClmpl-methodC() 실행");
    }

    @Override
    public void methodA() {
        System.out.println("InterfaceClmpl-methodA() 실행");

    }

    @Override
    public void methodB() {
        System.out.println("InterfaceClmpl-methodB() 실행");

    }
}
