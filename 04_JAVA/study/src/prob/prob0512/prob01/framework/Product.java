package prob0512.prob01.framework;

public interface Product extends Cloneable{
    void use(String content);
    Product createCopy();
}
