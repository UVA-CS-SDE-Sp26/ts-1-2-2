
public class UserInterface {
    public String parseArgs(String[] args){
        String result = "";
        if(args.length == 0){
            result =  "Listing available files to decipher: ";
            // call file handler to do this
        }
        else if(args.length == 1){
            if(!args[0].matches("\\d+")){
                result = args[0] + " is not a valid file input; it must be an number";
            }
            else{
                result = "Printing file "+args[0]+" using the default key";
                // call file handler
            }

        }
        else if(args.length == 2){
            if(!args[0].matches("\\d+")){
                result = args[0] + " is not a valid file input; it must be an number";
            }
            else{
                result =  "Printing file "+args[0]+" using the " +args[1]+" key";
                // call file handler
            }
        }
        else{
            result =  "Error: The user may only provide up to two arguments: a file number and an alternate key";
        }
        return result;
    }


}
