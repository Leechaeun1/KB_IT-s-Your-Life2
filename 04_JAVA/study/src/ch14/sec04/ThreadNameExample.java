package ch14.sec04;

public class ThreadNameExample {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName() + "실행");

        for (int i = 0; i < 3; i++) {
            Thread threadA = new Thread() {
                @Override
                public void run() {
                    System.out.println(getName() + "실행"); // 자동 할당된 스레드 이름 출력
                }
            };
            threadA.start();
        }
        Thread chatThread = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + "실행");
            }
        };
        chatThread.setName("chat-thread"); // 스레드 이름 변경
        chatThread.start();
    }
}
