import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CipherTest {

    @Test
    void defaultKeyDeciphersCorrectly() throws Exception {
        Path ciphers = Path.of("ciphers");
        Files.createDirectories(ciphers);

        Files.write(ciphers.resolve("key.txt"), List.of(
                "ABC",
                "XYZ"
        ));

        Cipher cipher = new Cipher();
        assertEquals("ABC", cipher.decipher("XYZ"));
    }

    @Test
    void alternateKeyDeciphersCorrectly() throws Exception {
        Path ciphers = Path.of("ciphers");
        Files.createDirectories(ciphers);

        Files.write(ciphers.resolve("secret.txt"), List.of(
                "ABC",
                "XYZ"
        ));

        Cipher cipher = new Cipher();
        assertEquals("ABC", cipher.decipher("XYZ", "secret"));
    }

    @Test
    void nonCipherCharactersRemainUnchanged() throws Exception {
        Path ciphers = Path.of("ciphers");
        Files.createDirectories(ciphers);

        Files.write(ciphers.resolve("key.txt"), List.of(
                "ABC",
                "XYZ"
        ));

        Cipher cipher = new Cipher();
        assertEquals("A!C", cipher.decipher("X!Z"));
    }

    @Test
    void invalidCipherThrowsException() throws Exception {
        Path ciphers = Path.of("ciphers");
        Files.createDirectories(ciphers);

        Files.write(ciphers.resolve("key.txt"), List.of(
                "ABC",
                "XXY"
        ));

        Cipher cipher = new Cipher();
        assertThrows(IllegalArgumentException.class, () -> cipher.decipher("XYZ"));
    }
}
