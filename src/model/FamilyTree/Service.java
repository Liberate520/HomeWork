package model.FamilyTree;

import model.Gender.Gender;
import model.Human.Human;

import java.time.LocalDate;

public class Service {
    private int idFamilyItem;
    private FamilyTree<Human> familyTree;

    public Service() {
        familyTree = new FamilyTree<>();
    }

    public void addFamilyItem(String name, Gender gender, LocalDate birthDate){
        Human human = new Human(idFamilyItem++, name, gender, birthDate);
        familyTree.addFamilyItem(human);
    }

    public String findFamilyItemByName(String name){
        return familyTree.findFamilyItemByName(name);
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByAge(){
        familyTree.sortByAge();
    }

    public String showFamilyTree(){
        return familyTree.toString();
    }

    public void AddParentOrChild(int idChild, int idParent){
        familyTree.findFamilyItemById(idChild).addParent(familyTree.findFamilyItemById(idParent));
        familyTree.findFamilyItemById(idParent).addChild(familyTree.findFamilyItemById(idChild));

    }


//    public void addChild(int idChild, int idParent) {
//        familyTree.findFamilyItemById(idParent).addChild(familyTree.findFamilyItemById(idChild));
//    }
}
