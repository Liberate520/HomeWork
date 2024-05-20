package Family_tree.Humans;
import java.time.LocalDate;

public class Female extends Human{

    private String nee;

    public Female(String name, Female mother, Male father, LocalDate birthDate, LocalDate deathDate, String nee){
        super(name, mother, father, birthDate, deathDate);
        this.nee = nee;
    }
    public Female(String name){
        super(name);
        this.nee = null;
    }

    public String getNee(){
        return this.nee;
    }
    public void setNee(String value){
        this.nee = value;
    }
    
}
