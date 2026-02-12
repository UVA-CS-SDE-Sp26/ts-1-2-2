import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CipherTest {

    @Test
    void defaultKeyDeciphersCorrectly() throws Exception {
        Path root = Files.createTempDirectory("proj");
        Path ciphers = Files.createDirectory(root.resolve("ciphers"));
        Files.write(ciphers.resolve("key.txt"), List.of(
                "ABC",
                "XYZ"
        ));

        System.setProperty("user.dir", root.toString());

        Cipher cipher = new Cipher();
        assertEquals("ABC", cipher.decipher("XYZ"));
    }

    @Test
    void alternateKeyDeciphersCorrectly() throws Exception {
        Path root = Files.createTempDirectory("proj");
        Path ciphers = Files.createDirectory(root.resolve("ciphers"));
        Files.write(ciphers.resolve("secret.txt"), List.of(
                "ABC",
                "XYZ"
        ));

        System.setProperty("user.dir", root.toString());

        Cipher cipher = new Cipher();
        assertEquals("ABC", cipher.decipher("XYZ", "secret"));
    }

    @Test
    void nonCipherCharactersStaySame() throws Exception {
        Path root = Files.createTempDirectory("proj");
        Path ciphers = Files.createDirectory(root.resolve("ciphers"));
        Files.write(ciphers.resolve("key.txt"), List.of(
                "ABC",
                "XYZ"
        ));

        System.setProperty("user.dir", root.toString());

        Cipher cipher = new Cipher();
        assertEquals("A!C", cipher.decipher("X!Z"));
    }

    @Test
    void invalidCipherThrowsException() throws Exception {
        Path root = Files.createTempDirectory("proj");
        Path ciphers = Files.createDirectory(root.resolve("ciphers"));
        Files.write(ciphers.resolve("key.txt"), List.of(
                "ABC",
                "XXY"
        ));

        System.setProperty("user.dir", root.toString());

        Cipher cipher = new Cipher();
        assertThrows(IllegalArgumentException.class, () -> cipher.decipher("XYZ"));
    }
}
