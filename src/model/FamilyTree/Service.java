package model.FamilyTree;

import model.Human.Gender;
import model.Human.Human;

import java.time.LocalDate;

public class Service {
    private int countPeople;
    FamilyTree tree = new FamilyTree<>();

    public void addHuman(String name, String secondName, Gender gender, LocalDate birthDate){
        Human human = new Human(name, secondName, gender, birthDate);
        tree.add(human);
    }
    public String getHumanListInfo(){
        return tree.getInfo();
    }
    public void sortByName(){
        tree.sortByName();
    }
    public void sortByAge(){
        tree.sortByBirthDate();
    }

}
