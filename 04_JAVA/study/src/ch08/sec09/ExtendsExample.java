package ch08.sec09;

public class ExtendsExample {
    public static void main(String[] args) {
        InterfaceClmpl impl = new InterfaceClmpl();

        InterfaceA ia = impl;
        ia.methodA();
//        ia.methodB();

        InterfaceB ib = impl;
//        ia.methodA();
        ib.methodB();

        InterfaceC ic = impl;
        ia.methodA();
        ib.methodB();
        ic.methodC();


    }
}