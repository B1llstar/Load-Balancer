import java.io.FileReader;
import java.util.*; // for array lists
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class Header {

    int sequenceNum;
    String name;
    String lineToSend;
    ArrayList<Header> allHeaders = new ArrayList<Header>(6);

    Header(int sequenceNum, String name, String lineToSend) {
        this.sequenceNum = sequenceNum;
        this.name = name;
        this.lineToSend = lineToSend;
    }

    /*
     * populateHeadersArray() {
     * 
     * Header(0, "HEAD", "HEAD " + hostName + " HTTP/1.1"); Header(1, "Host",
     * "Host: " + hostName); Header(2, "User-Agent", "User-Agent: bacon"); Header(3,
     * "Accept", "Accept: text/html"); Header(4, "Accept-Language", "en-US");
     * Header(5, "Connection", "Connect: close"); // out.println() remember to call
     * this }
     * 
     * outputHeaderLinesInSequence() {
     * 
     * 
     * return line; }
     */
}