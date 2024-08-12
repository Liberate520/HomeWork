package View.Exceptions;

public class CommandERROR extends Exception{
    public CommandERROR(String message){
        super(message);
    }

    public CommandERROR(){
        this("Unknown command.");
    }
}
