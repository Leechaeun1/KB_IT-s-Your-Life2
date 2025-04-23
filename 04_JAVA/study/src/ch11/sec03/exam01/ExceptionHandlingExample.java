package ch11.sec03.exam01;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        String[] array = {"100", "1oo"};

        for (int i = 0; i <= array.length; i++) {
            try {
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]:" + value); // i = 0일 때 정상 실행
            } catch (ArrayIndexOutOfBoundsException e) { // i = 2일 때 인덱스 예외
                System.out.println("배역 인덱스가 초과됨: " + e.getMessage());
            } catch (NumberFormatException e) { // i = 1일 때 format 예외
                System.out.println("숫자로 변환할 수 없음: " + e.getMessage());
            }
        }
    }
}
