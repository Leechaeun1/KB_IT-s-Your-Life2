package org.scoula.domain;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Parrot {
    public String name;

    @PostConstruct
    public void init() {
        this.name="Kiki";
    }

    public String setName(String koko) {
        return name;
    }

    public String getName() {
        return this.name;
    }
}
