package youareell;

import controllers.*;
import org.json.simple.JSONArray;
import java.io.IOException;

public class YouAreEll {

    TransactionController tt;

    public YouAreEll (TransactionController t) {
        this.tt = t;
    }

    public static void main(String[] args) throws IOException {
        // hmm: is this Dependency Injection?
        MessageController messageController = MessageController.shared();
        System.out.println(messageController.messagesSeen);
//        ServerController serverController = ServerController.shared();
//        serverController.idGet();
//        serverController.messageGet();
//        YouAreEll urlhandler = new YouAreEll(
//            new TransactionController(
//                new MessageController(), new IdController()
//        ));
//        System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
//        System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
//    }
//
//    public String get_ids() {
//        return tt.makecall("/ids", "GET", "");
//    }
//
//    public String get_messages() {
//        return MakeURLCall("/messages", "GET", "");
//    }

    }
}
