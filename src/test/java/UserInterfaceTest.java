//import org.junit.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class UserInterfaceTest {
    //all below tests are for the parseArgs method in the UserInterface class
    @Test
    public void testZeroArgs(){
        String[] args = {};
        UserInterface userInterface = new UserInterface();
        assertEquals("Listing available files to decipher: ",userInterface.parseArgs(args));
    }

    @Test
    public void testOneArg(){
        String[] args = {"01"};
        UserInterface userInterface = new UserInterface();
        assertEquals("Printing file "+args[0]+" using the default key",userInterface.parseArgs(args));
    }

    @Test
    public void testNotDigit(){
        String[] args = {"filea.txt"};
        UserInterface userInterface = new UserInterface();
        assertEquals(args[0] +" is not a valid file input; it must be an number",userInterface.parseArgs(args));
    }

    @Test
    public void testTwoArgs(){
        String[] args = {"01","secretkey"};
        UserInterface userInterface = new UserInterface();
        assertEquals("Printing file "+args[0]+" using the " +args[1]+" key",userInterface.parseArgs(args));
    }

    @Test
    public void testMoreThanTwoArgs(){
        String[] args = {"01","secretkey","abc"};
        UserInterface userInterface = new UserInterface();
        assertEquals("Error: The user may only provide up to two arguments: a file number and an alternate key",userInterface.parseArgs(args));
    }
}