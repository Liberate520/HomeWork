package OOP.SemDZ.homeWork.model.human;

import java.time.LocalDate;

public interface Creature {
    public String getName();
    public Gender getGender();
    public LocalDate getBirthDay();
    public int getId();
    public void setId(int id);
    public <T> void setSpouse(T spouse);
    public <T> void setFather(T father);
    public <T> void setMather(T mather);   
}

