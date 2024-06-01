package Family_tree.Humans;

import java.time.LocalDate;
import java.util.Set;

public interface EndothermalInterface<T> extends Comparable<T>{

    boolean addChild(T child);
    T getMother();
    void setMother(T value);
    T getFather();
    void setFather(T value);
    int getAge();    
    Set<T> getChildren();
    void setBirthDate(LocalDate birthDate);
    void setDeathDate(LocalDate deathDate);
    Gender getGender();
    Vital getVital();
    void setVital (Vital value);
    String toString();
    String getName();
    String getlnfo();
    String getChildrenlnfo();
    long getInnerID();
    void setInnerID(long id);



}
