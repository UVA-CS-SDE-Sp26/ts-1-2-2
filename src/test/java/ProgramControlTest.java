import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProgramControlTest {

    // check if no arguments are given, it lists all files
    @Test
    void noArguments() {
        String[] args = {}; // no args
        UserInterface ui = new UserInterface(args);
        FileHandler fh = new FileHandler();
        Cipher cipher = new Cipher();

        ProgramControl pc = new ProgramControl(ui, fh, null); // doing null bc cannot access exact files
        String result = pc.run(new String[]{}); // no args

        assertTrue(result.contains("01")); // file number
        assertTrue(result.contains("txt")); // file name
    }

    // check if one argument is given (so uses default key), the program returns
    @Test
    void oneArgument_defaultKey() {
        String[] args = {"1"};
        UserInterface ui = new UserInterface(args);
        FileHandler fh = new FileHandler();
        Cipher cipher = new Cipher();

        ProgramControl pc = new ProgramControl(ui, fh, null);
        String result = pc.run(new String[]{"1"});

        assertTrue(result.contains("Printing file 1")); // should output this based on user interface code
        assertTrue(result.contains("default key")); // output should have default in it
        assertNotNull(result);
    }

    // check if two args are presented (an alternate decipher key is used), it returns
    @Test
    void twoArguments_alternateKey() {
        String[] args = {"1","secretkey"};
        UserInterface ui = new UserInterface(args);
        FileHandler fh = new FileHandler();
        Cipher cipher = new Cipher();

        ProgramControl pc = new ProgramControl(ui, fh, null);
        String result = pc.run(new String[]{"1", "secretkey"});

        assertTrue(result.contains("Printing file 1")); // should output file num
        assertTrue(result.contains("secretkey")); // should output this bc key was given
    }

    // check if invalid file number is given, error is thrown
    @Test
    void invalidFile() {
        String[] args = {"abc"}; // non num not allowed
        UserInterface ui = new UserInterface(args);
        FileHandler fh = new FileHandler();
        Cipher cipher = new Cipher();

        ProgramControl pc = new ProgramControl(ui, fh, null);
        String result = pc.run(new String[]{"abc"});

        assertTrue(result.contains("Error")); // error message should be sent
    }
}