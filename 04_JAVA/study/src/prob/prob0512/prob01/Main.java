package prob0512.prob01;

import prob0512.prob01.framework.Manager;
import prob0512.prob01.framework.Product;

public class Main {
    public static void main(String[] args) {
        // 준비
        Manager manager = new Manager();


        CardTemplate mbox = new CardTemplate('~',"[Instagram Post]");
        CardTemplate sbox = new CardTemplate('#', "[Youtube Thumbnail]");

        // 등록

        manager.register("~~", mbox);
        manager.register("##", sbox);

        // 생성과 사용


        Product p2 = manager.create("~~");
        p2.use("오늘 점심은 연남동 김밥 🍙");
        System.out.println();
        Product p3 = manager.create("##");
        p3.use("🧸 자바로 구현한 내 인생 첫 프로그램!");

    }
}
