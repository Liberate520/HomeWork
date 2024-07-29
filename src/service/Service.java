package service;

import builder.HumanBuilder;
import family.FamilyTree;
import human.Gender;
import human.Human;

import java.io.Serializable;
import java.time.LocalDate;

public class Service implements Serializable {
    private FamilyTree<Human> tree;
    private HumanBuilder builder;

    public Service() {
        tree = new FamilyTree<>();
        builder = new HumanBuilder();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate){
        Human human = builder.build(name, gender, birthDate);
        tree.addHuman(human);
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate, String motherName, String fatherName){
        Human father = tree.getByName(fatherName);
        Human mother = tree.getByName(motherName);
        Human human = builder.build(name, gender, birthDate, mother, father);
        tree.addHuman(human);
    }

    public String getPeopleInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Списов людей:\n");

        for (Human human : tree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByAge(){
        tree.sortByAge();
    }

    public void setWedding(String human1, String human2){
        tree.setWedding(tree.getByName(human1), tree.getByName(human2));
    }

    @Override
    public String toString() {
        return getPeopleInfo();
    }
}
