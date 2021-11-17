import java.io.FileReader;
import java.util.*; // for array lists
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

// Self-contained header assembler
public class HeaderAssembler {

    String headerString = "";
    String[] headerVariables = { "XXhostNameXX", "XXconnectionTypeXX, XXuserAgentXX" };

    HeaderAssembler() {
        buildHeaderString(readJSON("headers.json"));
        insertVars("www.discord.com", "close", "bacon");
    }

    public JSONObject readJSON(String path) {
        JSONParser parser = new JSONParser();
        JSONObject tempJSON = null;
        try {
            Object obj = parser.parse(new FileReader("resources/" + path));
            JSONObject jsonObject = (JSONObject) obj;
            jsonObject.toJSONString();
            tempJSON = (JSONObject) jsonObject.get("Headers");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempJSON;
    }

    public void insertVars(String hostName, String connectionType, String userAgent) {
        headerString = headerString.replaceAll("XXhostNameXX", hostName);
        headerString = headerString.replaceAll("XXconnectionTypeXX", connectionType);
        headerString = headerString.replaceAll("XXuserAgentXX", userAgent);
    }

    // Iterate through json, grab any 'print' properties
    // Those will be printed over stream to submit requests

    public void buildHeaderString(JSONObject next) {

        var iterator = next.keySet().iterator();

        while (iterator.hasNext()) {
            var key = iterator.next();
            JSONObject properties = (JSONObject) next.get(key);
            // Each request begins with a special newline \r\n

            if (!iterator.hasNext()) {
                // End of GET Request
                headerString = headerString + "\r\n\r\n"; // Use special newline twice
                System.out.println("Assembler successfully built header string. Ready!");
            } else {
                System.out.println("LINE: " + properties.get("print"));
                headerString = headerString + properties.get("print") + "\r\n";
            }

        }

    }

}