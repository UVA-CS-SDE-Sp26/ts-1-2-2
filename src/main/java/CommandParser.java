import java.util.ArrayList;

public class CommandParser {
    private static final String DEFAULT_KEY = "DEFAULT";
    public static String handle(String[] args, ArrayList<String> files) throws IllegalAccessException {
        if(args.length == 0){
            return "";

        }

        if(args.length > 2){
            throw new IllegalAccessException("Error: The user may only provide up to two arguments: a file number and an alternate key");
        }

        if(!args[0].matches("\\d+")){
            throw new IllegalArgumentException("Error: File index must be a number.");
        }
        String file = args[0];
        int index = Integer.parseInt(args[0]);
        if(index < 0 || index > files.size()){
            throw new IllegalArgumentException("Error: No file found at that index");
        }
        String key = "";
        if(args.length == 2){
            key = args[1];
        }
        else{
            key = DEFAULT_KEY;
        }
        String fileName = files.get(index);

        return "Displaying "+fileName+" using key "+key;
    }

    private static String listFiles(ArrayList<String> files){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < files.size(); i++){
            sb.append(i+1);
            sb.append(files.get(i));
        }
        return sb.toString();
    }

}
