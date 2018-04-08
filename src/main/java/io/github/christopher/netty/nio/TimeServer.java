package io.github.christopher.netty.nio;

public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;
        MultipexerTimeServer timeServer = new MultipexerTimeServer(port);
        new Thread(timeServer, "NIO-MultipexerTimeServer-001").start();
    }
}
