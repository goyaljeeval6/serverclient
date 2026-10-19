import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Connect to server
            Socket socket = new Socket("localhost", 5000);

            System.out.println("Connected to server!");

            // Send message to server
            PrintWriter output = new PrintWriter(
                socket.getOutputStream(), true
            );

            output.println("Hello Server!");

            // Receive response from server
            BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );

            String response = input.readLine();

            System.out.println("Server says: " + response);

            // Close connection
            socket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}