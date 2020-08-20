package by.epam.info_handling.web;

import java.io.*;
import java.net.Socket;

public class SocketWrapper {

    private static final SocketWrapper instance = new SocketWrapper();

    private Socket socket;

    private SocketWrapper() {
    }

    public static SocketWrapper getInstance() {
        return instance;
    }

    public void writeMessage(String message) throws IOException {
        PrintWriter writer = new PrintWriter(getSocket().getOutputStream());
        writer.println(message);
        writer.flush();
    }

    public <T> T readObject() throws IOException, ClassNotFoundException {
        ObjectInputStream objectOutputStream = new ObjectInputStream(getSocket().getInputStream());
        T element = (T) objectOutputStream.readObject();
        return element;
    }

    private Socket getSocket() throws IOException {
        if (socket == null) {
            socket = new Socket("localhost", 8080);
        }

        return socket;
    }
}
