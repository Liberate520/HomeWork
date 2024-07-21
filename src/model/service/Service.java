package model.service;

import java.time.LocalDate;

import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.writer.FileHandler;
import model.writer.Writer;
import model.builder.HumanBuilder;

public class Service {
    private HumanBuilder humanBuilder;
    private FamilyTree<Human> familyTree;
    private Writer writer;


    public Service() {
        familyTree = new FamilyTree<>();
        humanBuilder = new HumanBuilder();
        writer = new FileHandler();
    }

    public void addHuman(String name, Gender gender, LocalDate dateOfBirth){
        Human human = humanBuilder.build(name, gender, dateOfBirth);
        familyTree.addHuman(human);
    }

    public Human getHuman(int idHuman){
        return familyTree.getHuman(idHuman);
    }

    public void setParent(int idChildren, int idParent){
        Human parent = familyTree.getHuman(idParent);
        Human children = familyTree.getHuman(idChildren);
        if (parent.getGender() == Gender.Male){
            children.setFather(parent);
            parent.setChildren(children);
        } else {children.setMother(parent);}
    }

    public void setDateOfDeath(int idHuman, LocalDate dateOfDeath) {
        Human human = familyTree.getHuman(idHuman);
        human.setDateOfDeath(dateOfDeath);
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByAge(){
        familyTree.sortByAge();
    }

    public void save() {
        writer.save(familyTree);
    }

    public boolean loading() {
        if (writer.loading() != null) {
            familyTree = (FamilyTree) writer.loading();
            return true;
        } else {
            return false;
        }
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

    public String getFamilyTreeHuman(int idHuman){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное дерево:\n");
        stringBuilder.append("\n");
        for (Human human: familyTree){
            if (idHuman == human.getId()){
                stringBuilder.append(human);
                stringBuilder.append("\n\n");
                stringBuilder.append("Мать:\n");
                stringBuilder.append(human.getMother());
                stringBuilder.append("\n\n");
                stringBuilder.append("Отец:\n");
                stringBuilder.append(human.getFather());
                stringBuilder.append("\n\n");
                stringBuilder.append("Дети:\n");
                stringBuilder.append(human.getChildren());
            } 
        }
        return stringBuilder.toString();
    }

}
