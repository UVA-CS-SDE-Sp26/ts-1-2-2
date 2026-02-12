
public class UserInterface {
    public String parseArgs(String[] args){
        String result = "";
        if(args.length == 0){
            return  "Listing available files to decipher: ";
            // call file handler to do this
        }
        else if(!args[0].matches("\\d+")){
            return args[0] + " is not a valid file input; it must be an number";
        }
        else if(args.length == 1){
            return "Printing file "+args[0]+" using the default key";
            // call file handler

        }
        else if(args.length == 2){
            return  "Printing file "+args[0]+" using the " +args[1]+" key";
        }
        else{
            return  "Error: The user may only provide up to two arguments: a file number and an alternate key";
        }
    }


}
