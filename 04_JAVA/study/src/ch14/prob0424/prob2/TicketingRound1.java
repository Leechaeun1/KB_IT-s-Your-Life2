package ch14.prob0424.prob2;

public class TicketingRound1 {
    public static void main(String[] args) {
        Thread fan1 = new Thread() {
            @Override
            public void run() {
                Thread thread = Thread.currentThread();
                System.out.println(thread.getName() + " 티켓 구매 시도 중!");
            }
        };
        fan1.setName("팬1");

        Thread fan2 = new Thread() {
            @Override
            public void run() {
                Thread thread = Thread.currentThread();
                System.out.println(thread.getName() + " 티켓 구매 시도 중!");
            }
        };

        System.out.println("=== run() 직접 호출 테스트 ===");
        fan1.start();
        fan2.start();
        fan1.run();
    }
}
