
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class UserInterfaceTest {
    @Test
    public void testZeroArgs(){
        String[] args = {};
        UserInterface userInterface = new UserInterface();
        //UserInterface commandParser = new UserInterface();
        assertEquals("Listing available files to decipher: ",userInterface.parseArgs(args));
    }

    @Test
    public void testOneArg(){
        String[] args = {"filea.txt"};
        UserInterface userInterface = new UserInterface();
        assertEquals("Printing file "+args[0]+" using the default key",userInterface.parseArgs(args));
    }

    @Test
    public void testTwoArgs(){
        String[] args = {"filea.txt","secretkey"};
        UserInterface userInterface = new UserInterface();
        assertEquals("Printing file "+args[0]+" using the " +args[1]+" key",userInterface.parseArgs(args));
    }

    @Test
    public void testMoreThanTwoArgs(){
        String[] args = {};
        UserInterface userInterface = new UserInterface();
        assertEquals("Error: The user may only provide up to two arguments: a file number and an alternate key",userInterface.parseArgs(args));
    }
}