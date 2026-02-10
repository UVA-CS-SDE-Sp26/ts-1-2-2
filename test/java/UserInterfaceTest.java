import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class UserInterfaceTest {
    private final ArrayList<String> files =
            List.of("filea.txt", "fileb.txt", "filec.txt");
    @Test
    void noArgumentsListFile(){
        CommandResult result = CommandParser.parse(new String []{},files);
        assertTrue(result.contains("01 filea.txt"));
        assertTrue(result.contains("02 fileb.txt"));
        assertTrue(result.contains("03 filec.txt"));

    }

    @Test
    void oneArgumentValidFileUseDefaultKey(){
        CommandResult result = CommandParser.parse(new String []{"01"},files);
        assertTrue(result.contains("filea.txt"));
        assertTrue(result.contains("DEFAULT"));
    }

    @Test
    void twoArgumentsValidFileUseAltKey(){
        CommandResult result = CommandParser.parse(new String []{"01","SecretKey"},files);
        assertEquals(Action.SHOW_FILE,result.getAction());
        assertTrue(result.contains("filea.txt"));
        assertTrue(result.contains("SecretKey"));
    }

    @Test
    void firstArgumentInvalid_ThrowError(){
        Exception e = assertThrows(IllegalArgumentException.class, ()-> CommandParser.parse(new String []{"abd"},files));
        assertEquals("Error: File index must be a number.",e.getMessage());

    }

    @Test
    void moreThanTwoArguments_ThrowError(){
        Exception e = assertThrows(IllegalArgumentException.class,() -> CommandParser.parse(new String []{"01","SecretKey","havefun"},files));
        assertEquals("Error: The user may only provide up to two arguments: a file number and an alternate key",e.getMessage());

    }

    @Test
    void invalidFileNumber_ThrowError(){
        Exception e = assertThrows(IllegalArgumentException.class, () -> CommandParser.parse(new String []{"99"}));
        assertEquals("Error: No file found at that index",e.getMessage());

    }
}