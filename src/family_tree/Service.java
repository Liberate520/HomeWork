package family_tree;

import human.Gender;
import human.Human;
import human.HumanBuilder;

import java.security.PublicKey;
import java.time.LocalDate;

public class Service<E extends FamilyTreeItem<E>>{
    private FamilyTree<E> familyTree;
    private HumanBuilder<E> humanBuilder;

    public Service(){
        familyTree = new FamilyTree<>();
        humanBuilder = new HumanBuilder<>();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate){
        E human = (E) humanBuilder.setName(name).setGender(gender).setBirthDate(birthDate).build();
        familyTree.add(human);
    }
    public boolean setWedding(String name1, String name2){
        return familyTree.setWedding(familyTree.findByName(name1), familyTree.findByName(name2));
    }
    public boolean setDivorce(String name1, String name2){
        return familyTree.setDivorce(familyTree.findByName(name1), familyTree.findByName(name2));
    }
    public boolean addChild(String human, String child){
        return familyTree.findByName(human).addChild(familyTree.findByName(child));
    }
    public boolean addParent(String human, String parent){
        return familyTree.findByName(human).addParent(familyTree.findByName(parent));
    }
    public FamilyTree<E> getFamilyTree() {
        return familyTree;
    }
    public void sortByName(){
        familyTree.sortByName();
    }
    public void sortByAge(){
        familyTree.sortByAge();
    }
    public void sortByBirthDate(){
        familyTree.sortByBirthDate();
    }
}
