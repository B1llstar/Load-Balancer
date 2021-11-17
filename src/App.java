import java.io.*;
import java.net.*;
import java.nio.Buffer;



public class App {

    public static void main(String[] args) {

        try {

            Socket client = new Socket("discord.com", 2000);
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);


            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
          
            HeaderAssembler assembler = new HeaderAssembler();
            System.out.println(assembler.headerString);
            // out.println(assembler.headerString);
          
            out.write("GET / HTTP/1.1\r\n" +
            "Host: www.discord.com\r\n\r\n");
          

            

            String temp;
            while ((temp = in.readLine()) != null) {
                System.out.println(temp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  
}