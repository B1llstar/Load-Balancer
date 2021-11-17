import java.net.ServerSocket;
import java.net.Socket;

import org.xml.sax.InputSource;

import java.io.*;

public class Server {
    public static void main(String[] args) {
        System.out.println("Server running!");
        try {
            ServerSocket server = new ServerSocket(3000);
            Socket newSocket = server.accept();
            System.out.println("Made a connection");
            BufferedReader in = new BufferedReader(new InputStreamReader(newSocket.getInputStream()));
            PrintWriter out = new PrintWriter(newSocket.getOutputStream());

            while (true) {

                String cringe;
                if ((cringe = in.readLine()) != null) {
                    System.out.println(cringe);
                    out.println(cringe);
                    return;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
