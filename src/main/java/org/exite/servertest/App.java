package org.exite.servertest;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    private static final Logger log = Logger.getLogger(App.class);
    static ExecutorService pool = Executors.newWorkStealingPool();

    public static void main(String[] args) {

        Config.loadConfig();

        try (ServerSocket server = new ServerSocket(3535)) {
            log.info("Server socket created");

            while (!server.isClosed()) {

                Socket client = server.accept();

                pool.execute(new ClientHandler(client));
                log.info("Connection accepted.");
            }

            pool.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


