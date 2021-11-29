package chatProject.model.messages;

import chatProject.model.user.Status;
import chatProject.model.user.UserAccount;
import chatProject.model.user.UserInfo;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageTest {

    @Test
    public void getId() {
        int id = 42;
        final Message<Object> message = new Message<>(id, null, null);

        assertEquals("The message ID is not the one set in the constructor",
                id, message.getId());
    }

    @Test
    public void getContent() {
        String content = "TEST";
        final Message<String> message = new Message<>(0, null, content);

        assertEquals("The message content is not the one set in the constructor",
                content, message.getMessage());
    }

    @Test
    public void getSender() {
        UserAccount account = new UserAccount(1, "Sender");
        Status status = Status.ACTIVE;
        MessageOwnerConcrete owner = new MessageOwnerConcrete(account,status);
        UserInfo sender = new UserInfo(account, status);
        final Message<String> message = new Message<>(0,owner, null);

        assertEquals("Le sender doit être le même", owner, message.getSender());
    }
}