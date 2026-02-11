/**
 * Commmand Line Utility
 */

public class TopSecret {

    public  static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        String result = userInterface.parseArgs(args);
    }


}
