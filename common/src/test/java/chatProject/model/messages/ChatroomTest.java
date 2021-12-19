package chatProject.model.messages;

import chatProject.model.user.Status;
import chatProject.model.user.UserAccount;
import chatProject.model.user.UserInfo;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ChatroomTest {

    @Test
    public void getName(){

        //Arrange
        String name = "testName";

        //Act
        Chatroom<String> chatroom = new Chatroom<String>(name, null, null);

        //Assert
        assertEquals("Le name doit être le même", name, chatroom.getName());

    }

    @Test
    public void getOwner(){

        //Arrange
        UserAccount account = new UserAccount(1, "Guillaume");
        Status status = Status.ACTIVE;
        UserInfo owner = new UserInfo(account,status);

        //Act
        Chatroom<String> chatroom = new Chatroom<String>(null, owner, null);

        //Assert
        assertEquals("Le owner doit être le même",owner, chatroom.getOwner());
    }

    @Test
    public void addMessage(){

        //Arrange
        String content = "ceci est un message";
        ArrayList<Message<String>> messages= new ArrayList<Message<String>>() {};
        final Message<String> message = new Message<String>(0, null, content);

        //Act
        messages.add(message);
        Chatroom<String> chatroom = new Chatroom<String>(null,null, messages);

        //Assert
        assertEquals(chatroom.addMessage(null, content), messages.get(1));
    }

}
