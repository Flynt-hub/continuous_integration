package chatProject.model.messages;


import chatProject.model.user.Status;
import chatProject.model.user.UserAccount;
import chatProject.model.user.UserInfo;
import org.junit.Test;
import chatProject.model.messages.*;

import java.time.LocalTime;
import java.util.*;


import static org.junit.Assert.*;


public class ChatInstanceTest<T> {


    @Test
    public void getCurentChatrooms() {

        //Arrange
        ArrayList<Chatroom<T>> chatrooms = new ArrayList<Chatroom<T>>() {};
        Chatroom<T> chatroom1 = new Chatroom<T>("Chatroom1", null, null);
        Chatroom<T> chatroom2 = new Chatroom<T>("Chatroom2", null, null);
        chatrooms.add(chatroom1);
        chatrooms.add(chatroom2);

        UserAccount account = new UserAccount(1, "MyUser");
        Status status = Status.ACTIVE;
        UserInfo userInfo = new UserInfo(account, status);

        Map<UserInfo, LocalTime> map = new HashMap<>();
        map.put(userInfo, LocalTime.now());


        //Act
        ChatInstance<T> chatInstance = new ChatInstance<T>(chatrooms, map);

        //Assert

        assertEquals("retourne la meme liste de chatrooms non modifiable", chatInstance.getCurentChatrooms(), Collections.unmodifiableList(chatrooms));
    }
}
/*
    @Test
    public void addChatroom(){

        //Arrange
        List<Chatroom<T>> listChatroomInitiale= new ArrayList<Chatroom<T>>() {};
        Chatroom<T> chatroom1 = new Chatroom<T>("Chatroom1", null, null);

        listChatroomInitiale.add(chatroom1);
        int index = listChatroomInitiale.indexOf((chatroom1));

        //Act


        //Assert
        assertEquals(index, listChatroomInitiale.addChatroom(chatroom1));
    }
}
*/