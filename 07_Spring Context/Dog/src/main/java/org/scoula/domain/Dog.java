package org.scoula.domain;

public class Dog {
    private String name;
    private String breed;

    public String getName() {
        return name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return "[Dog] 이름: " + name + ", 견종: " + breed;
    }

    public void setName(String name) {
        this.name = name;

    }
}
