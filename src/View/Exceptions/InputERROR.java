package View.Exceptions;

public class InputERROR extends Exception{
    public InputERROR(String message){
        super(message);
    }

    public InputERROR(){
        this("Uncorrected input.");
    }
}
