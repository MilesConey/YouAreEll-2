package controllers;

import com.fasterxml.jackson.core.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.MalformedURLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServerController<JsonString> {
    private String rootURL = "http://zipcode.rocks:8085";
    HttpURLConnection connection;
    private static ServerController svr = new ServerController();

    private ServerController() {
    }

    public static ServerController shared() {
        return svr;
    }

    public JsonString idGet() {

        BufferedReader reader;
        String line = " ";
        StringBuffer response = new StringBuffer();
        JSONParser jsonParser = new JSONParser();
        try {
            URL url = new URL("http://zipcode.rocks:8085/ids");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);

            int status = connection.getResponseCode();
            System.out.println(status);
            if (status > 299) {
                reader = new BufferedReader((new InputStreamReader(connection.getErrorStream())));
                while ((line != null)) {
                    response.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader((new InputStreamReader(connection.getInputStream())));
               Object obj = jsonParser.parse(reader);
                JSONArray ids = (JSONArray) obj;
                System.out.println(ids);
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return(JsonString) response;
//
//    public JsonString idPost(JsonTypeInfo.Id) {
//        // url -> /ids/
//        // create json from Id
//        // request
//        // reply
//        // return json
//    }
//    public JsonString idPut(Id) {
//        // url -> /ids/
//    }


    }
}
// ServerController.shared.doGet()