package ch14.prob0424.prob1;

public class ThreadExample {
    public static void main(String[] args) {
        Thread music = new Thread(new MusicRunnable());
        Thread video = new Thread(new MovieThread());

        video.start();
        music.start();
    }
}
