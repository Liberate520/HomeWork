package OOP.SemDZ.homeWork.model.Service;

import java.time.LocalDate;

import OOP.SemDZ.homeWork.model.human.Creature;
import OOP.SemDZ.homeWork.model.human.Gender;
import OOP.SemDZ.homeWork.model.human.Human;


public interface Service <O> {
        
    public void addHuman (String name, Gender gender, LocalDate birthDate);
    public void loadOfFile();
    public void saveToFile();
    public  void addHuman(O human);
    public String printFamilyTree();
    public  void wedding (O groom, O bride);
    public void birthChildren(String name, Gender gender, LocalDate birthday, String IdFather, String IdMather);
    public void wedding (String groom, String bride);
    public void sortByName();
    public void sortByAge();

}
