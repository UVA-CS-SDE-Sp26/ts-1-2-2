import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cipher {

    // maps cipher characters to plaintext characters
    private final Map<Character, Character> map = new HashMap<>();

    public Cipher() {}

    // uses default key
    public String decipher(String text) {
        return decipher(text, "key");
    }

    // uses alternate key
    public String decipher(String text, String keyName) {
        loadKey(keyName);

        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // leave unchanged if not in cipher
            chars[i] = map.getOrDefault(chars[i], chars[i]);
        }
        return new String(chars);
    }

    // loads and validates the cipher key
    private void loadKey(String keyName) {
        map.clear();
        Path keyPath = Path.of("ciphers", keyName + ".txt");

        List<String> lines;
        try {
            lines = Files.readAllLines(keyPath);
        } catch (Exception e) {
            throw new IllegalArgumentException("Cipher key file could not be read");
        }

        if (lines.size() < 2) {
            throw new IllegalArgumentException("Invalid cipher file");
        }

        String plain = lines.get(0);
        String cipher = lines.get(1);

        if (plain.length() != cipher.length()) {
            throw new IllegalArgumentException("Cipher length mismatch");
        }

        Set<Character> used = new HashSet<>();
        for (int i = 0; i < cipher.length(); i++) {
            char c = cipher.charAt(i);
            if (!used.add(c)) {
                throw new IllegalArgumentException("Duplicate cipher character");
            }
            map.put(c, plain.charAt(i));
        }
    }
}
