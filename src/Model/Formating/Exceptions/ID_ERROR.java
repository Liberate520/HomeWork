package Model.Formating.Exceptions;

public class ID_ERROR extends Exception{
    public ID_ERROR(String message){
        super(message);
    }

    public ID_ERROR(){
        this("Unknown ID of entity.");
    }
}
