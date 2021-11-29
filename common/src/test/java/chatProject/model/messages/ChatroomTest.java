package chatProject.model.messages;

import chatProject.model.user.Status;
import chatProject.model.user.UserAccount;
import chatProject.model.user.UserInfo;
import org.junit.Test;

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
    /*
    @Test
    public void addMessage(){

        //Arrange

        //Act

        //Assert
    } */
}
