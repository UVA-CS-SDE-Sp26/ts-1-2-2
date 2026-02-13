//import org.junit.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class UserInterfaceTest {
    //all below tests are for the parseArgs method in the UserInterface class
    @Test
    public void testZeroArgs(){
        String[] args = {};
        UserInterface userInterface = new UserInterface(args);
        String reality = userInterface.parseArgs(args).getMessage();
        String expected = "Listing available files to decipher: ";
        assertEquals(expected,reality);
        assertEquals(0,userInterface.parseArgs(args).getStatus());
    }

    @Test
    public void testOneArg(){
        String[] args = {"01"};
        UserInterface userInterface = new UserInterface(args);
        String reality = userInterface.parseArgs(args).getMessage();
        String expected = "Printing file "+args[0]+" using the default key";
        assertEquals(expected,reality);
        assertEquals(1,userInterface.parseArgs(args).getStatus());

    }

    @Test
    public void testNotDigitOneArg(){
        String[] args = {"filea.txt"};
        UserInterface userInterface = new UserInterface(args);
        String reality = userInterface.parseArgs(args).getMessage();
        String expected = args[0] +" is not a valid file input; it must be an number";
        assertEquals(expected,reality);
        assertEquals(-1,userInterface.parseArgs(args).getStatus());

    }

    @Test
    public void testNotDigitTwoArg(){
        String[] args = {"filea.txt","secretkey"};
        UserInterface userInterface = new UserInterface(args);
        String reality = userInterface.parseArgs(args).getMessage();
        String expected = args[0] +" is not a valid file input; it must be an number";
        assertEquals(expected,reality);
        assertEquals(-1,userInterface.parseArgs(args).getStatus());

    }

    @Test
    public void testTwoArgs(){
        String[] args = {"01","secretkey"};
        UserInterface userInterface = new UserInterface(args);
        String reality = userInterface.parseArgs(args).getMessage();
        String expected = "Printing file "+args[0]+" using the " +args[1]+" key";
        assertEquals(expected,reality);
        assertEquals(2,userInterface.parseArgs(args).getStatus());

    }

    @Test
    public void testMoreThanTwoArgs(){
        String[] args = {"01","secretkey","abc"};
        UserInterface userInterface = new UserInterface(args);
        String reality = userInterface.parseArgs(args).getMessage();
        String expected = "Error: The user may only provide up to two arguments: a file number and an alternate key" +args[1]+" key";
        assertEquals(expected,reality);
        assertEquals(-1,userInterface.parseArgs(args).getStatus());

    }
}