package ch11.sec02.exam01;

public class ExceptionHandlingExample1 {
    public static void printLenghth(String data) {
        // 문제점 : data가 null일 경우 NullPointerException 발생
        // int result = data.length();

        //예외 처리 코드 추가
        try {
            int result = data.length();
            System.out.println("문자 수: " + result);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());

        } finally { //예외가 발생하든 안하든 무조건 실행
            System.out.println("[마무리 실행]\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLenghth("ThisIsJava");
        printLenghth(null);
        System.out.println("[프로그램 종료]");
    }
}

