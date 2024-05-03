package model.FamilyTree;

import model.Human.Gender;
import model.Human.Human;
import writer.FileHandler;

import java.time.LocalDate;

public class Service {
    private int countPeople;
    FamilyTree tree = new FamilyTree<>();
    String filePath = "src/writer/tree.txt";

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

    public void loadFamilyTree(){
        FileHandler fileHandler = new FileHandler();
        tree = (FamilyTree) fileHandler.read(filePath);
    }

    public void saveFamilyTree(){
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree, filePath);
        System.out.println("Семейное древо сохранено\n");
    }



}
