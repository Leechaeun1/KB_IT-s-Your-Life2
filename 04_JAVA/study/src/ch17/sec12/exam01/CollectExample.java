package ch17.sec12.exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {
    public static void main(String[] args) {
        List<Student> totalList = new ArrayList<>();
        totalList.add(new Student("홍길동", "남", 92));
        totalList.add(new Student("김수영", "여", 87));
        totalList.add(new Student("감자바", "남", 95));
        totalList.add(new Student("오해영", "여", 93));

        // 남학생만 묶어 List 생성
        // 1. stream 사용
        List<Student> maleList = totalList.stream()
                .filter(s -> s.getSex().equals("남"))
                .toList();

        maleList //.stream()
                .forEach(s-> System.out.println(s.getName()));

        maleList.forEach(System.out::println);

        maleList.stream()
                .map(Student::getName)
                .forEach(System.out::println);
        System.out.println();

        //2. stream 사용 X
//        List<Student> maleList = new ArrayList<>();
//        for (Student student : totalList) {
//            if (student.getSex().equals("남")) {
//                maleList.add(student);
//            }
//        }

        //학생 이름을 키, 학생의 점수를 값으로 갖는 Map 생성
        Map<String, Integer> map = totalList.stream()
                .collect(
                        Collectors.toMap(
                                s -> s.getName(),
                                s -> s.getScore()
                        )
                );
        System.out.println(map);
    }
}
