package Model.Formating.Exceptions;

public class Gender_ERROR extends Exception{
    public Gender_ERROR(String message){
        super(message);
    }

    public Gender_ERROR(){
        this("Unknown gender.");
    }
}
