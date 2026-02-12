import javax.crypto.Cipher;

/**
 * Commmand Line Utility
 */

public class TopSecret {

    public  static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        FileHandler fileHandler = new FileHandler();
        //Cipher cipher = new Cipher();
        //ProgramControl programControl = new ProgramControl(userInterface, fileHandler, cipher);

        String result = userInterface.parseArgs(args);

    }


}
