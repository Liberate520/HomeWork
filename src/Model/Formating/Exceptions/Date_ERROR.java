package Model.Formating.Exceptions;

public class Date_ERROR extends Exception{
    public Date_ERROR(String message){
        super(message);
    }

    public Date_ERROR(){
        this("Uncorrected values");
    }
}
