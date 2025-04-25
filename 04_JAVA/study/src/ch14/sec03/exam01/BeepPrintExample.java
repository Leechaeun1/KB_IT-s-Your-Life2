package ch14.sec03.exam01;

import java.awt.Toolkit;

public class BeepPrintExample {
    public static void main(String[] args) throws InterruptedException {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // 비프음을 5번 출력
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(500); // 0.5초간 일시 정지
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // "띵"을 5번 출력
        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500); // 0.5초간 일시 정지
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
