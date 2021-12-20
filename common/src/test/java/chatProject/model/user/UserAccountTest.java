package chatProject.model.user;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserAccountTest {

    @Test
    public void getId() {

        //Arrange
        final int id = 1;

        //Act
        final UserAccount user = new UserAccount(1,null);

        //Assert
        assertEquals("La méthode doit retourner l'id du user, soit 1", id, user.getId());
    }
    @Test
    public void getUsername() {

        final String username = "My user";
        final UserAccount user = new UserAccount(0, username);

        assertEquals("The username should be the one set in the constructor",
                username, user.getUsername());
    }

    @Test
    public void testEquals() {

        final UserAccount user1 = new UserAccount(1, "MyUser");
        final UserAccount user2 = new UserAccount(2, "MyUser");

        assertEquals("2 accounts are equal if they have the same username",
                user1.getUsername(), user2.getUsername());
    }

    @Test
    public void testHashCode() {

        final UserAccount user1 = new UserAccount(1, "MyUser");
        final UserAccount user2 = new UserAccount(2, "MyUser");

        assertEquals("2 accounts with the same username should have the same hashcode",
                user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testToString() {

        final UserAccount user = new UserAccount(0, "MyUser");
        assertEquals("The toString() method of a UserAccount should print the username",
                "MyUser", user.toString());
    }
}