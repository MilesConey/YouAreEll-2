//package controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import junit.framework.TestCase;
//import org.json.simple.JSONArray;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.logging.Logger;
//
//public class MessageControllerTest extends TestCase {
//
//    ServerController serverController =  ServerController.shared();
//
//    public void testGetMessages() throws IOException {
//        List<String> messageStr = new ArrayList<String>();
//        ObjectMapper objectMapper = new ObjectMapper();
//        JSONArray messages = ServerController.shared().messageGet();
//        messageStr.addAll(messages);
//        Map<String, String> map = objectMapper.readValue(DataInput) messageStr, Map,class);
//        System.out.println(map.size());
//        Logger.getLogger(String.valueOf(messageStr));
//
//    }
//}