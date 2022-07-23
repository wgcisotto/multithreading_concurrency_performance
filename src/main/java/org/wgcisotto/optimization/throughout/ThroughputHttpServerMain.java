package org.wgcisotto.optimization.throughout;

import com.sun.net.httpserver.HttpServer;
import org.wgcisotto.optimization.throughout.handler.WordCountHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThroughputHttpServerMain {

    private static final String INPUT_FILE = "./resources/war_and_peace.txt";
    private static final int NUMBER_OF_THREADS = 16;

    public static void main(String[] args) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
        startServer(text);
    }

    public static void startServer(String text) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/search", new WordCountHandler(text));
        Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        server.setExecutor(executor);
        server.start();
    }

}
