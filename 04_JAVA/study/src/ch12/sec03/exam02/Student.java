package ch12.sec03.exam02;

import java.util.Objects;

public class Student {
    private int no;
    private String name;

    private Student(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student student)) return false;
        // 학번과 이름이 같으면 true
        return no == student.no && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
