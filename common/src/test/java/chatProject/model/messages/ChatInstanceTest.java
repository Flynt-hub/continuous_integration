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


    @Test
    public void addChatroom(){

        //Arrange
        ArrayList<Chatroom<T>> chatrooms = new ArrayList<Chatroom<T>>() {};
        Chatroom<T> chatroom = new Chatroom<T>("Chatroom1", null, null);
        chatrooms.add(chatroom);

        UserAccount account = new UserAccount(1, "MyUser");
        Status status = Status.ACTIVE;
        UserInfo userInfo = new UserInfo(account, status);

        Map<UserInfo, LocalTime> map = new HashMap<>();
        map.put(userInfo, LocalTime.now());

        //Act
        int index = chatrooms.indexOf((chatroom));
        ChatInstance<T> chatInstance = new ChatInstance<T>(chatrooms, map);

        //Assert
        assertEquals("retourne l'id de la chatroom dans la liste de chatrooms", index, chatInstance.addChatroom(chatroom));
    }

    @Test
    public void addUser_1(){

        //Arrange
        ArrayList<Chatroom<T>> chatrooms = new ArrayList<Chatroom<T>>() {};

        UserAccount account = new UserAccount(1, "MyUser");
        Status status = Status.ACTIVE;
        UserInfo userInfo = new UserInfo(account, status);

        Map<UserInfo, LocalTime> map = new HashMap<>();


        //Act
        map.put(userInfo, LocalTime.now());
        ChatInstance<T> chatInstance = new ChatInstance<T>(chatrooms, map);

        //Assert
        assertFalse("le nouvel utilisateur à été ajouté, retourne false", chatInstance.addUser(userInfo));
    }

    @Test
    public void addUser_2(){

        //Arrange
        ArrayList<Chatroom<T>> chatrooms = new ArrayList<Chatroom<T>>() {};

        UserAccount account_1 = new UserAccount(1, "MyUser_1");
        UserAccount account_2 = new UserAccount(2, "MyUser_2");

        Status status = Status.ACTIVE;

        UserInfo userInfo_1 = new UserInfo(account_1, status);
        UserInfo userInfo_2 = new UserInfo(account_2, status);
        Map<UserInfo, LocalTime> map = new HashMap<>();


        //Act
        map.put(userInfo_1, LocalTime.now());

        ChatInstance<T> chatInstance = new ChatInstance<T>(chatrooms, map);

        //Assert
        assertTrue("le nouvel utilisateur existe pas, on ajoute l'ajoute, retourne true", chatInstance.addUser(userInfo_2));

    }


    @Test
    public void getUsers(){

        //Arrange
        ArrayList<Chatroom<T>> chatrooms = new ArrayList<Chatroom<T>>() {};
        Chatroom<T> chatroom = new Chatroom<T>("Chatroom1", null, null);
        chatrooms.add(chatroom);

        UserAccount account_1 = new UserAccount(1, "MyUser_1");
        UserAccount account_2 = new UserAccount(2, "MyUser_2");

        Status status_1 = Status.ACTIVE;
        Status status_2 = Status.ACTIVE;

        UserInfo userInfo_1 = new UserInfo(account_1, status_1);
        UserInfo userInfo_2 = new UserInfo(account_1, status_1);

        Map<UserInfo, LocalTime> map = new HashMap<>();
        map.put(userInfo_1, LocalTime.now());
        map.put(userInfo_2, LocalTime.now());

        //Act
        ChatInstance<T> chatInstance = new ChatInstance<T>(chatrooms, map);

        //Assert
        assertEquals("retourne la lister des users", chatInstance.getUsers(), map);
    }

    @Test
    public void initEmptyChat(){

        //Arrange
        ArrayList<Chatroom<T>> chatrooms = new ArrayList<Chatroom<T>>();
        Chatroom<T> chatroom = new Chatroom<T>("Chatroom1", null, null);
        chatrooms.add(chatroom);

        UserAccount account = new UserAccount(1, "MyUser");
        Status status = Status.ACTIVE;
        UserInfo userInfo = new UserInfo(account, status);

        Map<UserInfo, LocalTime> map = new HashMap<UserInfo, LocalTime>();
        map.put(userInfo, LocalTime.now());


        //Act

        ChatInstance<T> chatInstance = new ChatInstance<T>(chatrooms, map);
        ChatInstance<T> chatInstanceTest = new ChatInstance<T>(chatrooms, map);

        ChatInstance.initEmptyChat();

        //Assert
        assertNotEquals("retourne une nouvelle chatInstance", chatInstance, chatInstanceTest);

    }
}
