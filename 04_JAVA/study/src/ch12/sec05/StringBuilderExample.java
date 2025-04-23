package ch12.sec05;

public class StringBuilderExample {
    public static void main(String[] args) {
        // 메소드 체이닝 패턴
        String data = new StringBuilder() // StringBuilder 객체 생성
                .append("DEF") // "DEF 추가"
                .insert(0, "ABC") // 0번 위치에 "ABC" 삽입
                .delete(3, 4) // 3번 인덱스 문자 'D' 삭제
                .toString();
        System.out.println(data);
    }
}
