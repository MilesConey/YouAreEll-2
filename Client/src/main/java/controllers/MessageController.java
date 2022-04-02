package controllers;

import java.util.ArrayList;
import java.util.HashSet;

import models.Id;
import models.Message;
import org.json.simple.JSONArray;

public class MessageController {
    public HashSet<Message> messagesSeen = new HashSet<>(); //TODO change back to private

    private MessageController() {
        ServerController serverController = ServerController.shared();
        JSONArray messagesJSON = serverController.messageGet();
//        Message[] messages = (Message[]) messagesJSON.toArray(new message[0]);
        for (int i = 0; i < messagesJSON.size(); i++) {
            Object object = messagesJSON.get(i);
            String string = object.toString();
            String[] messageList = string.split(",");
            String toID = messageList[0].substring(8);
            String sequence = messageList[1].substring(11);
            String message = messageList[2].substring(10);
            String fromID = messageList[3].substring(9);
            String timestamp = messageList[4].substring(12);
            Message messageObject = new Message(message, fromID, toID, timestamp, sequence);
            messagesSeen.add(messageObject);
        }
    }

        private static MessageController mesCon = new MessageController();

        public static MessageController shared() {
            return mesCon;
        }
//        private HashSet<Message> messagesSeen;
//        // why a HashSet??
//
//        public ArrayList<Message> getMessages () {
//            return null;
//        }
//        public ArrayList<Message> getMessagesForId (Id Id){
//            return null;
//        }
//        public Message getMessageForSequence (String seq){
//            return null;
//        }
//        public ArrayList<Message> getMessagesFromFriend (Id myId, Id friendId){
//            return null;
//        }
//
//        public Message postMessage (Id myId, Id toId, Message msg){
//            return null;
//        }
//
//    }
    }


