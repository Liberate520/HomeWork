package Family_tree.Model.Humans;

import java.io.Serializable;
import java.time.LocalDate;


public interface Endothermal extends Serializable, Comparable<Endothermal> {
    
    Endothermal getMother();  
    Endothermal getFather();    
    int getAge();   
    void setBirthDate(LocalDate birthDate); 
    void setDeathDate(LocalDate deathDate);
    Gender getGender();    
    String toString();
    String getName();
    String getInfo();
    String getChildrenlnfo();   
    long getInnerID();
}
