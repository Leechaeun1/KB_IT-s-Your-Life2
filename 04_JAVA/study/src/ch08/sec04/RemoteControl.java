package ch08.sec04;

public interface RemoteControl {
    // 인터페이스의 필드는 기본적으로 상수 (public static final 생략)
    int MAX_VOLUME = 10;
    int MIN_VOLUME = 0;

    // 인터페이스의 메소드는 기본적으로 추상 메소드(public abstract 생략)
    void turnOn();

    void turnOff();

    void setVolume(int volume);

}
