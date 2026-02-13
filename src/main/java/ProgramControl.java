import java.io.IOException;
import java.util.*;

public class ProgramControl {
    private UserInterface ui;
    private FileHandler fileHandler;
    private Cipher cipher; // fill in with cipher class name

    // constructor
    public ProgramControl(UserInterface ui, FileHandler fileHander, Cipher cipher) {
        this.ui = ui;
        this.fileHandler = fileHander;
        this.cipher = cipher;
    }

    /* main method that returns the correct content:
        get file list from file handler, get the contents from user interface,
        list the files based on user input, check what cipher is used,
        decipher message, and print contents */
    public String run(String[] args) {
        // retrieve the list of files from the file handler class
        List<String> files = fileHandler.listFiles();
        ArrayList<String> fileList = new ArrayList<>(files);

        // use command parser to handle the user's input
        UserInterface.Tuple tuple = ui.parseArgs(args);
        String message = tuple.getMessage();
        if(tuple.getStatus()==-1){
            return message;
        }
        // if no args are given, list the files
        if (args.length == 0) {
            String result = message + "\n";

            for (int i=0; i < fileList.size(); i++) {
                result += String.format("%02d %s%n", i + 1, fileList.get(i));
            }

            return result;
        }

        // if an invalid arg is given (handled by user interface)
        if (!args[0].matches("\\d+")) {
            return message;
        }

        // make the user input into an integer value (originally a string)
        int index = Integer.parseInt(args[0]) - 1; // -1 because index starts at 0

        // if an invalid file number is given
        if (index < 0 || index >= fileList.size()) {
            return "Error: a file at this index does not exist.";
        }

        // get the file name at the given index using file handler
        String fileName = fileList.get(index);

        // check if the cipher uses default key or not
        String key;
        if (args.length == 2)
            key = args[1]; // user gives key
        else
            key = "key"; // default key's name

        // get the file contents from file handler

        String fileContent;
        try {
            fileContent = fileHandler.readFile(fileName);
            // use fileContent
        } catch (IOException e) {
            return "Error: Unable to read file.";
        }

        // use the key to decipher this content
        String deciphered = fileContent;
        if (cipher != null)
            deciphered = cipher.decipher(fileContent, key);

        // final return: the file name and its contents
        return message + "\n" + deciphered;
    }

}