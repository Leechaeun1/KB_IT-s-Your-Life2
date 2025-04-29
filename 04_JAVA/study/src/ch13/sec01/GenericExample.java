package ch13.sec01;

import javax.swing.*;

public class GenericExample {
    public static void main(String[] args) {
        //Box<String> box1 = new Box<String>();
         // 다이아몬드 연산자, <> 안에 타입 생략시 타입 추론 가능
        Box<String> box1 = new Box<>();
        box1.content = "안녕하세요.";
        String str = box1.content;
        System.out.println(str);

        //Primitive 타입은 제네릭에 사용 불가능
        Box<Integer> box2 = new Box<>();
        box2.content = 100;
        int value = box2.content;
        System.out.println(value);
    }
}
