package ch17.sec01;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("홍길동");
        set.add("신용권");
        set.add("김자바");

        // Stream을 이용한 요소 반복 처리
        Stream<String> stream = set.stream();
        stream.forEach(name -> System.out.println(name));

        stream = set.stream();
        stream.forEach(System.out::println);

    }
}
