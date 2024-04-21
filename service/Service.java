package homeWork.service;

import java.time.LocalDate;
import homeWork.human.Human;
import homeWork.familyTree.FamilyTree;
import homeWork.gender.Gender;


public class Service {
    private FamilyTree<Human> tree1;


    public Service() {
        tree1 = new FamilyTree<>();
    }

    public void addHuman(String name, LocalDate dob, LocalDate dod, Gender gender, Human mother, Human father){
        Human human = new Human(name, dob, dod, gender, mother, father);
        tree1.addHuman(human);
    }

    public void addHuman(String name, LocalDate dob, Gender gender, Human mother, Human father){
        addHuman(name, dob, null, gender, mother, father);
    }

    public void addHuman(String name, LocalDate dob, Gender gender){
        addHuman(name, dob, null, gender, null, null);
    }

    public String getTree(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное дерево:\n");
        for (Human human: tree1){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getTree();
    }

    public void sortbyName(){
        tree1.sortbyName();
    }

    public void sortbyDate(){
        tree1.sortbyDate();
    }
}
