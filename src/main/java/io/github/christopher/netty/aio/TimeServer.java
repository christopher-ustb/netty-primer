package io.github.christopher.netty.aio;

public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;
        AsyncTimeServerHandler serverHandler = new AsyncTimeServerHandler(port);
        new Thread(serverHandler, "AIO-AsyncTimeServerHandler-001").start();
    }
}
