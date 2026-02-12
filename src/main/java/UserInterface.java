import static java.lang.System.exit;



public class UserInterface {
    private String [] args;

    static class Tuple {
        private int status;
        private String message;

        public Tuple(String message, int status){
            this.status = status;
            this.message = message;
        }

        public int getStatus(){
            return status;
        }
        public String getMessage(){
            return message;
        }
        public void setStatus(int status){
            this.status = status;
        }
        public void setMessage(String message){
            this.message = message;
        }
    }

    public UserInterface(String[] args) {
        this.args = args;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public Tuple parseArgs(String[] args){
        if(args.length == 0){
            return  new Tuple("Listing available files to decipher: ",0);
        }
        else if(!args[0].matches("\\d+")){
            return new Tuple("Error: "+args[0] + " is not a valid file input; it must be an number",-1);
        }
        else if(args.length == 1){
            return new Tuple("Printing file "+args[0]+" using the default key",1);
        }
        else if(args.length == 2){
            return  new Tuple("Printing file "+args[0]+" using the " +args[1]+" key",2);
        }
        else{
            return  new Tuple("Error: The user may only provide up to two arguments: a file number and an alternate key",-1);
        }
    }


}
