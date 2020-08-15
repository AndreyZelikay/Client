package by.epam.info_handling;

import java.io.*;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080)) {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write("abcd\n");
            writer.flush();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
