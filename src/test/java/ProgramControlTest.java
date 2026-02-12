/*
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockit0.*;
import org.junit.jupiter.api.Test;
import java.util.*;

@ExtendWith(MockitoExtension.class)
public class ProgramControlTest {

    // mock the file handler and cipher classes
    @Mock
    FileHandler fileHandler;

    @Mock
    Cipher cipher;

    // check that if no arguments are given, the files and corresponding number will be listed
        // similar to the first test in the UserInterface test file
    @Test
    void noArgument() {
        ArrayList<String> files = new ArrayList<>(List.of(filea.txt, fileb.txt); // mock list of files

        when(fileHandler.getFileList()).thenReturn(files)); // simulate returning files

        programControl pc = new ProgramControl(fileHandler, cipher); // objects
        String result = pc.run(new String[]{});

        assertTrue(result.contains("filea.txt")); // checks
        assertTrue(result.contains("fileb.txt"));
    }

    // check that the user inputs a number for a file type, throws error if not
        // this is similar to the last test in the UserInterface file
    @Test
    void invalidFile() {
        ArrayList<String> files = new ArrayList<>(List.of("filea.txt"); // just one file

        while(fileHandler.getFileList()).thenReturn(files)); // simulate returning files

        ProgramControl pc = new ProgramControl(fileHandler,cipher);

        Exception e = assertThrows(IllegalArgumentException.class, () -> pc.run(new String[]{"99"}));
        assertEquals("Error: The user must provide a relevant file index number.")
    }

    // check that the right output gets returned with the default cipher
    @Test
    void validFile_default() {
        ArrayList<String> files = new ArrayList<>(List.of("filea.txt"));

        // simulate using returning the files and using the default cipher
        when(fileHandler.getFileList()).thenReturn(files);
        when(fileHandler.getFileContents("filea.txt")).thenReturn("XYZ");
        when(cipher.decipher("XYZ", "Default")).thenReturn("ABC");

        ProgramControl pc = new ProgramControl(fileHandler, cipher);
        String result = pc.run(new String[]{"1"});

        assertTrue(result.contains("ABC")); // should match mocked decipher above
    }

    // check that the right output gets returned with an alternate cipher
    @Test
    void validFile_alternate() {
        ArrayList<String> files = new ArrayList<>(List.of("filea.txt"));

        // simulate using returning the files and using the cipher
        when(fileHandler.getFileList()).thenReturn(files);
        when(fileHandler.getFileContents("filea.txt")).thenReturn("XYZ");
        when(cipher.decipher("XYZ", "SecretKey")).thenReturn("ABC");

        ProgramControl pc = new ProgramControl(fileHandler, cipher);
        String result = pc.run(new String[]{"1", "SecretKey"});

        assertTrue(result.contains("ABC")); // should match mocked decipher above
    }
}

 */