package prob0512.prob01;

import prob0512.prob01.framework.Product;

public class CardTemplate implements Product {
    private char frameChar;
    private String title;

    public CardTemplate(char frameChar, String  title) {
        this.frameChar = frameChar;
        this.title = title;
    }

    @Override
    public void use(String content) {
        int ulen = content.length();

        System.out.println(title);
        for (int i = 0; i < ulen+10; i++) {
            System.out.print(frameChar);
        }
        System.out.println();
        System.out.println(content);
        for (int i = 0; i < ulen+10; i++) {
            System.out.print(frameChar);
        }
        System.out.println();
    }

    @Override
    public Product createCopy() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
