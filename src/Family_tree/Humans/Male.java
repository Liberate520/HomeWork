package Family_tree.Humans;
import java.time.LocalDate;


public class Male extends Human {

    public Male(String name, Female mother, Male father, LocalDate birthDate, LocalDate deathDate){
        super(name, mother, father, birthDate, deathDate);
    }
    public Male(String name){
        super(name);
    }
    
    
}
