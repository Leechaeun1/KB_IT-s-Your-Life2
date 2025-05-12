package prob0512.prob01.framework;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<String, Product> showcase = new HashMap<>();

    public void register(String name, Product p) { // 원본 등록
        showcase.put(name, p);
    }


    public Product create(String name) {
        Product p = showcase.get(name);
        return p.createCopy();
    }
}
