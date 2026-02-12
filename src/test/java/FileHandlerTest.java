import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FileHandlerTest {
    @Test
    void listFilesReturnsAllFilesInDirectory() {
        FileHandler fileHandler = new FileHandler();
        List<String> files = fileHandler.listFiles();
        assertTrue(files.contains("carnivore.txt"));
        assertTrue(files.contains("cointelpro.txt"));
    }

    @Test
    void readFilesReturnsCorrectContents() {
        FileHandler fileHandler = new FileHandler();
        String contains = fileHandler.readFile("carnivore.txt");
        assertTrue(contains.contains("Carnivore, later renamed DCS1000, was a system implemented by the Federal Bureau of Investigation (FBI) that was\n" +
                "designed to monitor email and electronic communications. It used a customizable packet sniffer that could monitor all\n" +
                "of a target user's Internet traffic. Carnivore was implemented in October 1997. By 2005 it had been replaced with\n" +
                "improved commercial software."));
    }

    @Test
    void readFilesThrowsExceptionWhenFileDoesNotExist() {
        FileHandler fileHandler = new FileHandler();
        String contains = fileHandler.readFile("nothere.txt");
        assertThrows(IOException.class, () -> {
            fileHandler.readFile("nothere.txt");
        });
    }

}
