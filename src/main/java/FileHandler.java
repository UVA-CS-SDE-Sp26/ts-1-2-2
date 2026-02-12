import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

public class FileHandler {

    private static final String dataFolder = "data";

    public List<String> listFiles(){
        try {
            return Files.list(Paths.get(dataFolder))
                    .filter(Files::isRegularFile)
                    .map(path -> path.getFileName().toString())
                    .sorted()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Unable to read data directory", e);
        }
    }
    
    public String readFile(String fileName) {
        Path filePath = Paths.get(dataFolder, fileName);
        try {
            return Files.readString(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
