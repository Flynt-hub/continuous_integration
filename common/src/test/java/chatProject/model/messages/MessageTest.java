package chatProject.model.messages;

import chatProject.model.user.Status;
import chatProject.model.user.UserAccount;
import chatProject.model.user.UserInfo;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageTest {

    @Test
    public void getId() {

        //Arrange
        int id = 42;

        //Act
        final Message<Object> message = new Message<Object>(id, null, null);

        //Assert
        assertEquals("The message ID is not the one set in the constructor",
                id, message.getId());
    }

    @Test
    public void getContent() {

        //Arrange
        String content = "TEST";

        //Act
        final Message<String> message = new Message<String>(0, null, content);

        //Assert
        assertEquals("The message content is not the one set in the constructor",
                content, message.getMessage());
    }

    @Test
    public void getSender() {

        //Arrange
        UserAccount account = new UserAccount(1, "Sender");
        Status status = Status.ACTIVE;
        MessageOwnerConcrete owner = new MessageOwnerConcrete(account,status);
        UserInfo sender = new UserInfo(account, status);

        //Act
        final Message<String> message = new Message<String>(0,owner, null);

        //Assert
        assertEquals("Le sender doit être le même", owner, message.getSender());
    }
}