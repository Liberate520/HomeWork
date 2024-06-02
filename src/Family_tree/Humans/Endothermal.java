package Family_tree.Humans;

import java.io.Serializable;
import java.time.LocalDate;


public interface Endothermal extends Serializable, Comparable<Endothermal> {
    
    Endothermal getMother();  
    Endothermal getFather();    
    int getAge();   
    void setBirthDate(LocalDate birthDate); 
    void setDeathDate(LocalDate deathDate);
    Gender getGender();
    Vital getVital();
    void setVital (Vital value);
    String toString();
    String getName();
    String getlnfo();
    String getChildrenlnfo();
    void setFamilyID( int value);
    int getFamilyID();
    void setInFamilyStatus(boolean b);
    boolean inFamily();
    long getInnerID();
}
