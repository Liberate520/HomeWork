package homeWork.Model.Service;

import java.time.LocalDate;
import homeWork.Model.Human.Gender;
import homeWork.Model.Human.Human;
import homeWork.Model.Tree.FamilyTree;


public class Service {
    private int idHuman;
    private FamilyTree<Human> service;
    private SaverLoader saverLoader = new SaverLoader();

    public Service(){
        service = new FamilyTree<>();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        Human human = new Human(idHuman++, name, gender, birthDate, deathDate);
        service.addHuman(human);
    }


    public void removeHuman(int idHuman) {
        service.removeHuman(getHumanById(idHuman));
    }

    public void addChildren(Human human){
        Human mother = getHumanById(human.getMother().getId());
        Human father = getHumanById(human.getFather().getId());
        mother.addChild(human);
        father.addChild(human);
    }

    private Human getHumanById(int idHuman) {
        for (Human human : service) {
            if (human.getId() == idHuman) {
                return human;
            }
        }
        return null;
    }

    public String getFamilyTree(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семьи:\n");
        for (Human human : service){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }



    public void sortByName(){
        service.sortByName();
    }

    public void sortByAge(){
        service.sortByAge();
    }
    
    
    
    public void saveToFile(String fileName){
        saverLoader.saveToFile(service, fileName);
    }

    public void loadFromFile(String fileName){
        saverLoader.loadFromFile(fileName);
    }
    
}