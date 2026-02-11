
public class UserInterface {
    public String parseArgs(String[] args){
        String result = "";
        if(args.length == 0){
            result =  "Listing available files to decipher: ";
            // call file handler to do this
        }
        else if(args.length == 1){
            result = "Printing file "+args[0]+" using the default key";
        }
        else if(args.length == 2){
            result =  "Printing file "+args[0]+" using the " +args[1]+" key";
        }
        else{
            result =  "Error: The user may only provide up to two arguments: a file number and an alternate key";
        }
        return result;
    }


}
