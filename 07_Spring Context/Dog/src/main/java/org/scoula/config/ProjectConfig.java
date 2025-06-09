package org.scoula.config;

import org.scoula.domain.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean(name="꼬미")
    public Dog dog() {
        Dog d = new Dog();
        d.setName("꼬미");
        d.setBreed("푸들");
        return d;
    }

    @Bean(name="밤비")
    public Dog dog2() {
        Dog d = new Dog();
        d.setName("밤비");
        d.setBreed("시바견");
        return d;
    }

    @Bean(name="해피")
    public Dog dog3() {
        Dog d = new Dog();
        d.setName("해피");
        d.setBreed("진돗개");
        return d;
    }


}
