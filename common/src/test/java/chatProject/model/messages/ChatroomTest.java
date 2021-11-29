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
        Chatroom chatroom = new Chatroom(name, null, null);

        //Assert
        assertEquals(name, chatroom.getName());
        //assertNotEquals("testNegatif", chatroom.getName());
    }
    /*
    @Test
    public void getOwner(){

        //Arrange
        UserAccount account = new UserAccount(1, "Guillaume");
        Status status = Status.ACTIVE;
        UserInfo owner = new UserInfo(account,status);

        //Act
        Chatroom chatroom = new Chatroom(null, owner, null);

        //Assert
        assertEquals(owner, chatroom.getOwner());
    }

    @Test
    public void addMessage(){

        //Arrange

        //Act

        //Assert
    } */
}
