package service;

import java.time.LocalDate;

import builder.HumanBuilder;
import family_tree.FamilyTree;
import human.Gender;
import human.Human;

public class Service {
    private HumanBuilder humanBuilder;
    private FamilyTree familyTree;

    public Service() {
        familyTree = new FamilyTree();
        humanBuilder = new HumanBuilder();
    }

    public void addHuman(String name, Gender gender, LocalDate dateOfBirth){
        Human human = humanBuilder.build(name, gender, dateOfBirth);
        familyTree.addHuman(human);
    }

    public void setMother(int idChildren, int idMother){
        Human mother = familyTree.getHuman(idMother);
        Human children = familyTree.getHuman(idChildren);
        children.setMother(mother);
    }

    public void setFather(int idChildren, int idFather) {
        Human father = familyTree.getHuman(idFather);
        Human children = familyTree.getHuman(idChildren);
        children.setFather(father);
    }

    public void setChildren(int idParent, int idChildren) {
        Human parent = familyTree.getHuman(idParent);
        Human children = familyTree.getHuman(idChildren);
        parent.setChildren(children);
    }

    public void setDateOfDeath(int id, LocalDate dateOfDeath) {
        Human human = familyTree.getHuman(id);
        human.setDateOfDeath(dateOfDeath);
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByAge(){
        familyTree.sortByAge();
    }

    public String getHumansListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей:\n");
        for (Human human: familyTree){
            stringBuilder.append("\n");
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
