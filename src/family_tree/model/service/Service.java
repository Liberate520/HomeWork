package family_tree.model.service;

import family_tree.model.FamilyTree.FamilyTree;
import family_tree.model.Human.Gender;
import family_tree.model.Human.Human;
import family_tree.model.writer.FileHandler;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {


    private final FamilyTree<Human> familyTree;
    private final FileHandler fileHandler;

    public Service(){
        familyTree = new FamilyTree<>();
        fileHandler = new FileHandler();
    }

    public void addHuman(String name, LocalDate dob, LocalDate dod, Gender gender, List<Human> children, Human mother, Human father){
        Human human = new Human(name, dob, dod, gender, children, mother, father);
        familyTree.addHuman(human);
    }

    public List<Human> getHumanChildren(Human human){
        return familyTree.getHumanChildren(human);
    }

    public void addChild(String nameParents, List<Human> nameChild) {

        for(Human human: familyTree){
            if(human.getName().equals(nameParents)){
                human.setChildren(nameChild);
            }
        }
    }

    public void setMother(String name, Human nameMother) {

        for(Human human: familyTree){
            if(human.getName().equals(name)){
                human.setMother(nameMother);
            }
        }
    }

    public void setFather(String name, Human nameFather) {
        for(Human human: familyTree){
            if(human.getName().equals(name)){
                human.setFather(nameFather);
            }
        }
    }

    public String getHumanListInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Семейное дерево:\n");
        for(Human human:familyTree){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();

    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByBirthday(){
        familyTree.sortByBirthday();
    }

    public void writeExternal(Serializable serializable, String FilePath) throws IOException {
        fileHandler.writeExternal(serializable, FilePath);

    }

    public Object readExternal(String FilePath) throws IOException, ClassNotFoundException {
        return fileHandler.readExternal(FilePath);
    }
}
